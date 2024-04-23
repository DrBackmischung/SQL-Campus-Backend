package de.sqlcampus.backend.entities;

import java.util.List;

import org.springframework.lang.NonNull;

import de.sqlcampus.backend.misc.UuidIdentifiedEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="course")
public class Course extends UuidIdentifiedEntity {
	
	@Column
	@NonNull
	private String name;
	
	@Column
	@NonNull
	private String description;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable
	private List<Task> tasks;
	
	@Column
	@NonNull
	private int level;
	
	@Column
	@NonNull
	private boolean graded;
	
	@Column
	@NonNull
	private boolean mandatory;

	public Course(String name, String description, int level, boolean graded, boolean mandatory) {
		super();
		this.name = name;
		this.description = description;
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

	public void addTask(Task task) {
		this.tasks.add(task);
	}

	public void removeTask(Task task) {
		this.tasks.remove(task);
	}

}
