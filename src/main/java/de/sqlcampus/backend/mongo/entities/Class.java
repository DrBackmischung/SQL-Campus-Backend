package de.sqlcampus.backend.mongo.entities;

import java.sql.Date;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import de.sqlcampus.backend.misc.UuidIdentifiedEntity;

@Document
public class Class extends UuidIdentifiedEntity {
    
    @Field("name")
	private String name;

    @Field("school")
	private String school;
    
    @Field("start")
	private Date start;
    
    @Field("end")
	private Date end;

	public Class(String name, String school, Date start, Date end) {
		super();
		this.name = name;
		this.school = school;
		this.start = start;
		this.end = end;
	}
	
	public Class() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
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

}
