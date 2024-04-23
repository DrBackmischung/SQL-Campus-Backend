package de.sqlcampus.backend.entities;

import java.util.List;

import org.hibernate.annotations.Cascade;
import org.springframework.lang.NonNull;

import de.sqlcampus.backend.misc.UuidIdentifiedEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="task")
public abstract class Task extends UuidIdentifiedEntity {
	
	@Column
	@NonNull
	private String name;
	
	@Column
	@NonNull
	private String description;
	
	@Column
	@NonNull
	private String task;
	
	@Column
	@NonNull
	private String level;
	
	@Column
	@NonNull
	private int points;
	
	@Column
	private String sql;
	
	@Column
	private String eml;
	
	@Column
	private String abap;
	
	@Column
	private String answer;
	
	@ManyToMany(mappedBy="tasks")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<Course> courses;

	public Task(String name, String description, String task, String level, int points, String sql, String eml,
			String abap, String answer) {
		super();
		this.name = name;
		this.description = description;
		this.task = task;
		this.level = level;
		this.points = points;
		this.sql = sql;
		this.eml = eml;
		this.abap = abap;
		this.answer = answer;
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
