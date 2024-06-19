package de.sqlcampus.backend.h2.entities;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {

    @Id   
	@Column
    private String id;  

	@Column
	private String firstname;

	@Column
	private String lastname;

	@Column
	private String address;

	@Column
	private String city;

	@Column
	private String zipcode;

	@Column
	private String phone;

	@Column
	private String email;

	@Column
	private int salary;

	@Column
	private String role;

    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name = "supermarket", referencedColumnName = "id")
	private Supermarket supermarket;

}
