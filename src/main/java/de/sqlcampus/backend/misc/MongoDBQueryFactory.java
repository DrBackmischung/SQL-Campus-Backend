package de.sqlcampus.backend.misc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation.LocalFieldBuilder;
import org.springframework.data.mongodb.core.query.Criteria;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.DateValue;
import net.sf.jsqlparser.expression.DoubleValue;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.NotExpression;
import net.sf.jsqlparser.expression.StringValue;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.conditional.OrExpression;
import net.sf.jsqlparser.expression.operators.relational.Between;
import net.sf.jsqlparser.expression.operators.relational.EqualsTo;
import net.sf.jsqlparser.expression.operators.relational.ExpressionList;
import net.sf.jsqlparser.expression.operators.relational.InExpression;
import net.sf.jsqlparser.expression.operators.relational.LikeExpression;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.GroupByElement;
import net.sf.jsqlparser.statement.select.Join;
import net.sf.jsqlparser.statement.select.OrderByElement;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;

public class MongoDBQueryFactory {

    public static Aggregation convertSQLToMongoAggregation(String sql) throws JSQLParserException {
        Statement statement = CCJSqlParserUtil.parse(sql);

        if (statement instanceof Select) {
            return convertSelectToAggregation((Select) statement);
        }

        throw new UnsupportedOperationException("Only SELECT statements are supported.");
    }

    private static Aggregation convertSelectToAggregation(Select selectStatement) {
        PlainSelect plainSelect = (PlainSelect) selectStatement.getSelectBody();

        List<AggregationOperation> operations = new ArrayList<>();

        // Handle FROM
        String mainTable = plainSelect.getFromItem().toString();

        // Initialize the first collection as the main collection
        operations.add(Aggregation.match(new Criteria())); // No-op to set the initial collection

        // Handle JOINs
        List<Join> joins = plainSelect.getJoins();
        if (joins != null) {
            for (Join join : joins) {
                String joinTable = join.getRightItem().toString();
                Expression onExpression = join.getOnExpression();
                if (onExpression != null) {
                    List<Criteria> criteriaList = parseJoinConditions(onExpression);
                    operations.add(createJoinOperation(mainTable, joinTable, criteriaList, join.isLeft(), join.isRight()));
                }
            }
        }

        // Handle WHERE
        Expression whereExpression = plainSelect.getWhere();
        if (whereExpression != null) {
            operations.add(Aggregation.match(parseExpression(whereExpression)));
        }

        // Handle GROUP BY
        GroupByElement groupBy = plainSelect.getGroupBy();
        if (groupBy != null) {
            List<String> groupByFields = new ArrayList<>();
            for (Expression groupByExpression : groupBy.getGroupByExpressions()) {
                groupByFields.add(groupByExpression.toString());
            }
            operations.add(Aggregation.group(groupByFields.toArray(new String[0])));
        }

        // Handle HAVING
        Expression havingExpression = plainSelect.getHaving();
        if (havingExpression != null) {
            operations.add(Aggregation.match(parseExpression(havingExpression)));
        }

        // Handle ORDER BY
        List<OrderByElement> orderByElements = plainSelect.getOrderByElements();
        if (orderByElements != null) {
            for (OrderByElement orderByElement : orderByElements) {
                String field = orderByElement.getExpression().toString();
                Sort.Direction direction = orderByElement.isAsc() ? Sort.Direction.ASC : Sort.Direction.DESC;
                operations.add(Aggregation.sort(Sort.by(direction, field)));
            }
        }

        return Aggregation.newAggregation(operations);
    }

    private static LookupOperation createJoinOperation(String mainTable, String joinTable, List<Criteria> criteriaList, boolean isLeftJoin, boolean isRightJoin) {
        LocalFieldBuilder builder = LookupOperation.newLookup().from(joinTable);

        // Assuming simple equality join condition for demonstration purposes
        if (!criteriaList.isEmpty()) {
            Criteria firstCriteria = criteriaList.get(0);
            String localField = firstCriteria.getKey();
            Object foreignFieldValue = firstCriteria.getCriteriaObject().values().iterator().next();
            String foreignField = foreignFieldValue.toString();
            builder.localField(localField).foreignField(foreignField);
        }

        return builder.as(joinTable);
    }

    private static List<Criteria> parseJoinConditions(Expression onExpression) {
        List<Criteria> criteriaList = new ArrayList<>();

        if (onExpression instanceof EqualsTo) {
            EqualsTo equalsTo = (EqualsTo) onExpression;
            Column leftColumn = (Column) equalsTo.getLeftExpression();
            Column rightColumn = (Column) equalsTo.getRightExpression();

            criteriaList.add(Criteria.where(leftColumn.getColumnName()).is(rightColumn.getColumnName()));
        } else if (onExpression instanceof AndExpression) {
            AndExpression andExpression = (AndExpression) onExpression;
            criteriaList.addAll(parseJoinConditions(andExpression.getLeftExpression()));
            criteriaList.addAll(parseJoinConditions(andExpression.getRightExpression()));
        } else if (onExpression instanceof OrExpression) {
            OrExpression orExpression = (OrExpression) onExpression;
            criteriaList.addAll(parseJoinConditions(orExpression.getLeftExpression()));
            criteriaList.addAll(parseJoinConditions(orExpression.getRightExpression()));
        } else {
            throw new UnsupportedOperationException("Join condition not supported: " + onExpression.getClass().getName());
        }

        return criteriaList;
    }

    private static Criteria parseExpression(Expression expression) {
        if (expression instanceof EqualsTo) {
            EqualsTo equalsTo = (EqualsTo) expression;
            Column column = (Column) equalsTo.getLeftExpression();
            Expression valueExpression = equalsTo.getRightExpression();

            Object value = convertExpressionValue(valueExpression);
            return Criteria.where(column.getColumnName()).is(value);
        } else if (expression instanceof AndExpression) {
            AndExpression andExpression = (AndExpression) expression;
            return new Criteria().andOperator(parseExpression(andExpression.getLeftExpression()), parseExpression(andExpression.getRightExpression()));
        } else if (expression instanceof OrExpression) {
            OrExpression orExpression = (OrExpression) expression;
            return new Criteria().orOperator(parseExpression(orExpression.getLeftExpression()), parseExpression(orExpression.getRightExpression()));
        } else if (expression instanceof LikeExpression) {
            LikeExpression likeExpression = (LikeExpression) expression;
            Column column = (Column) likeExpression.getLeftExpression();
            StringValue value = (StringValue) likeExpression.getRightExpression();
            return Criteria.where(column.getColumnName()).regex(value.getValue());
        } else if (expression instanceof Between) {
            Between between = (Between) expression;
            Column column = (Column) between.getLeftExpression();
            Expression startExpression = between.getBetweenExpressionStart();
            Expression endExpression = between.getBetweenExpressionEnd();
            return Criteria.where(column.getColumnName()).gte(convertExpressionValue(startExpression)).lte(convertExpressionValue(endExpression));
        } else if (expression instanceof InExpression) {
            InExpression inExpression = (InExpression) expression;
            Column column = (Column) inExpression.getLeftExpression();
            List<Expression> inItems = ((ExpressionList) inExpression.getRightItemsList()).getExpressions();
            List<Object> values = new ArrayList<>();
            for (Expression inItem : inItems) {
                values.add(convertExpressionValue(inItem));
            }
            return Criteria.where(column.getColumnName()).in(values);
        } else if (expression instanceof NotExpression) {
            NotExpression notExpression = (NotExpression) expression;
            return Criteria.where(parseExpression(notExpression.getExpression()).toString()).not();
        }

        // Add more parsing logic as needed for other types of expressions

        throw new UnsupportedOperationException("Expression type not supported: " + expression.getClass().getName());
    }

    private static Object convertExpressionValue(Expression valueExpression) {
        if (valueExpression instanceof StringValue) {
            return ((StringValue) valueExpression).getValue();
        } else if (valueExpression instanceof LongValue) {
            return ((LongValue) valueExpression).getValue();
        } else if (valueExpression instanceof DoubleValue) {
            return ((DoubleValue) valueExpression).getValue();
        } else if (valueExpression instanceof DateValue) {
            return ((DateValue) valueExpression).getValue();
        }

        // Add more types as needed, e.g., TimeValue, TimestampValue, etc.

        return valueExpression.toString();
    }

}
