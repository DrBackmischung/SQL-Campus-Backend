package de.sqlcampus.backend.mongo.entities;

import java.sql.Date;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import de.sqlcampus.backend.misc.UuidIdentifiedEntity;

@Document
public class Assignment extends UuidIdentifiedEntity {

    @Field("user")
    @DBRef
	private User user;

    @Field("start")
	private Date start;

    @Field("end")
	private Date end;

    @Field("course")
    @DBRef
	private Course course;

	public Assignment(User user, Date start, Date end, Course course) {
		super();
		this.user = user;
		this.start = start;
		this.end = end;
		this.course = course;
	}
	
	public Assignment() {}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
    
}
