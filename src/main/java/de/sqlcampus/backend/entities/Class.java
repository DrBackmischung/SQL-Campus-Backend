package de.sqlcampus.backend.entities;

import java.sql.Date;

import org.springframework.lang.NonNull;

import de.sqlcampus.backend.misc.UuidIdentifiedEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="class")
public class Class extends UuidIdentifiedEntity {
	
	@Column
	@NonNull
	private String name;
	
	@Column
	@NonNull
	private String school;
	
	@Column
	@NonNull
	private Date start;
	
	@Column
	@NonNull
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
