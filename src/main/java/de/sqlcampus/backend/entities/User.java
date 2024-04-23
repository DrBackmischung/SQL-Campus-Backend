package de.sqlcampus.backend.entities;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Cascade;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User extends UuidIdentifiedEntity {
	
	@Column
	@NonNull
	private String username;
	
	@Column
	@NonNull
	private String firstname;
	
	@Column
	@NonNull
	private String lastname;
	
	@Column
	@NonNull
	private String email;
	
	@Column
	@NonNull
	private String password;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name = "class_id", referencedColumnName = "id")
	private Class dhbwClass;
	
	@OneToMany(mappedBy="userID")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<Course> courses = new ArrayList<>();

	public User(String username, String firstname, String lastname, String email, String password, Class dhbwClass) {
		super();
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.dhbwClass = dhbwClass;
	}
	
	public User() {}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Class getDhbwClass() {
		return dhbwClass;
	}

	public void setDhbwClass(Class dhbwClass) {
		this.dhbwClass = dhbwClass;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public void addCourse(Course course) {
		this.courses.add(course);
	}

	public void removeCourse(Course course) {
		this.courses.remove(course);
	}

}
