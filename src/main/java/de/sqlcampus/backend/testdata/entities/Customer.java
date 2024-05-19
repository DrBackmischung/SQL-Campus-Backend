package de.sqlcampus.backend.testdata.entities;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Customer {

    @Field("firstname")
	private String firstname;

    @Field("lastname")
	private String lastname;

    @Field("address")
	private String address;

    @Field("city")
	private String city;

    @Field("zipcode")
	private String zipcode;

    @Field("phone")
	private String phone;

    @Field("email")
	private String email;

    @Field("passwordHash")
	private String passwordHash;

    @Field("points")
	private int points;

}
