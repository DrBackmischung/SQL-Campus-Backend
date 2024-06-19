package de.sqlcampus.backend.mongo.entities;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class User extends UuidIdentifiedEntity {

    @Field("username")
	private String username;

    @Field("firstname")
	private String firstname;

    @Field("lastname")
	private String lastname;

    @Field("email")
	private String email;

    @Field("password")
	private String password;
    
    @Field("active")
    private boolean active;

    @Field("dhbwClass")
    @DBRef
	private Class dhbwClass;

    @Field("courses")
    @DBRef(lazy = true)
	private List<Course> courses;

	public User(String username, String firstname, String lastname, String email, String password, boolean active,
			Class dhbwClass, List<Course> courses) {
		super();
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.active = active;
		this.dhbwClass = dhbwClass;
		this.courses = courses;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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

}
