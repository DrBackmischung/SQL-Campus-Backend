package de.sqlcampus.backend.mongo.repo;

import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;

import de.sqlcampus.backend.misc.CustomEmptyRepository;
import de.sqlcampus.backend.misc.MongoDBQueryFactory;
import net.sf.jsqlparser.JSQLParserException;

public class ResultRepositoryImplementation implements CustomEmptyRepository {
	
    private final MongoTemplate mongoTemplate;

    public ResultRepositoryImplementation(MongoTemplate mongoTemplate) {
        this.mongoTemplate= mongoTemplate;
    }
    
    public boolean check(String actual, String expected, String mainCollectionName) {
    	try {
			Aggregation actualAggregation = MongoDBQueryFactory.convertSQLToMongoAggregation(actual);
			AggregationResults<Document> actualResults = mongoTemplate.aggregate(actualAggregation, mainCollectionName, Document.class);

			Aggregation expectedAggregation = MongoDBQueryFactory.convertSQLToMongoAggregation(actual);
			AggregationResults<Document> expectedResults = mongoTemplate.aggregate(expectedAggregation, mainCollectionName, Document.class);
			
			if(actualResults.getMappedResults().equals(expectedResults.getMappedResults()))
				return true;
			else
				return false;
		} catch (JSQLParserException e) {
			return false;
		}
    }

}
