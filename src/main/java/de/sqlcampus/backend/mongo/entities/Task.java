package de.sqlcampus.backend.mongo.entities;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public abstract class Task extends UuidIdentifiedEntity {

    @Field("name")
	private String name;

    @Field("description")
	private String description;

    @Field("task")
	private String task;

    @Field("level")
	private String level;

    @Field("points")
	private int points;

    @Field("autocompleteAllowed")
	private boolean autocompleteAllowed;

    @Field("sql")
	private String sql;

    @Field("eml")
	private String eml;

    @Field("abap")
	private String abap;

    @Field("answer")
	private String answer;

    @Field("courses")
    @DBRef(lazy = true)
	private List<Course> courses;

	public Task(String name, String description, String task, String level, int points, boolean autocompleteAllowed,
			String sql, String eml, String abap, String answer, List<Course> courses) {
		super();
		this.name = name;
		this.description = description;
		this.task = task;
		this.level = level;
		this.points = points;
		this.autocompleteAllowed = autocompleteAllowed;
		this.sql = sql;
		this.eml = eml;
		this.abap = abap;
		this.answer = answer;
		this.courses = courses;
	}
	
	public Task() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public boolean isAutocompleteAllowed() {
		return autocompleteAllowed;
	}

	public void setAutocompleteAllowed(boolean autocompleteAllowed) {
		this.autocompleteAllowed = autocompleteAllowed;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public String getEml() {
		return eml;
	}

	public void setEml(String eml) {
		this.eml = eml;
	}

	public String getAbap() {
		return abap;
	}

	public void setAbap(String abap) {
		this.abap = abap;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

}
