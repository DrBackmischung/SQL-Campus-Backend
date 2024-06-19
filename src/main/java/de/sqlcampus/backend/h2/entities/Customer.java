package de.sqlcampus.backend.h2.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {

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
	private String passwordHash;

	@Column
	private int points;

}
