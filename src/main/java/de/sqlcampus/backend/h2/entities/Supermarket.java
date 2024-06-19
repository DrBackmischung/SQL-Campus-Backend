package de.sqlcampus.backend.h2.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="supermarket")
public class Supermarket {

    @Id   
	@Column
    private String id;  

	@Column
	private String name;

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

	public Supermarket(String id, String name, String address, String city, String zipcode, String phone,
			String email) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.city = city;
		this.zipcode = zipcode;
		this.phone = phone;
		this.email = email;
	}
	
	public Supermarket() {}

}
