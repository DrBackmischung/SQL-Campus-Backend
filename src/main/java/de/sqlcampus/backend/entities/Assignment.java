package de.sqlcampus.backend.entities;

import java.sql.Date;
import java.util.UUID;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.lang.NonNull;

import de.sqlcampus.backend.misc.UuidIdentifiedEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="assignment")
public class Assignment extends UuidIdentifiedEntity {

	@Column(columnDefinition= "VARBINARY(16)")
	@NonNull
	private UUID userID;
	
	@Column
	@NonNull
	private Date start;
	
	@Column
	@NonNull
	private Date end;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name = "class_id", referencedColumnName = "id")
	private Course course;

	public Assignment(UUID userID, Date start, Date end, Course course) {
		super();
		this.userID = userID;
		this.start = start;
		this.end = end;
		this.course = course;
	}
	
	public Assignment() {}

	public UUID getUserID() {
		return userID;
	}

	public void setUserID(UUID userID) {
		this.userID = userID;
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
