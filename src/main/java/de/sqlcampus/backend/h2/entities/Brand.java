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

	public Brand(String id, String name, String address, String city, String zipcode, String phone, String email,
			String website, String mainContactName, String mainContactPhone, String mainContactEmail) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.city = city;
		this.zipcode = zipcode;
		this.phone = phone;
		this.email = email;
		this.website = website;
		this.mainContactName = mainContactName;
		this.mainContactPhone = mainContactPhone;
		this.mainContactEmail = mainContactEmail;
	}
	
	public Brand() {}

}
