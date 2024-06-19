package de.sqlcampus.backend.h2.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="brand")
public class Brand {

    @Id   
	@Column(nullable = false, unique = true)
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

	@Column
	private String website;

	@Column
	private String mainContactName;

	@Column
	private String mainContactPhone;

	@Column
	private String mainContactEmail;

}
