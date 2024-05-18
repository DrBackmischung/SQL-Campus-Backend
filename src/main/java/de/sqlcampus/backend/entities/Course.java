package de.sqlcampus.backend.entities;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import de.sqlcampus.backend.misc.UuidIdentifiedEntity;

@Document
public class Course extends UuidIdentifiedEntity {

    @Field("name")
	private String name;

    @Field("description")
	private String description;

    @Field("tasks")
    @DBRef(lazy = true)
	private List<Task> tasks;

    @Field("users")
    @DBRef(lazy = true)
	private List<User> users;

    @Field("level")
	private int level;

    @Field("graded")
	private boolean graded;

    @Field("mandatory")
	private boolean mandatory;

	public Course(String name, String description, List<Task> tasks, List<User> users, int level, boolean graded,
			boolean mandatory) {
		super();
		this.name = name;
		this.description = description;
		this.tasks = tasks;
		this.users = users;
		this.level = level;
		this.graded = graded;
		this.mandatory = mandatory;
	}
	
	public Course() {}

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

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public boolean isGraded() {
		return graded;
	}

	public void setGraded(boolean graded) {
		this.graded = graded;
	}

	public boolean isMandatory() {
		return mandatory;
	}

	public void setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
	}

}
