package de.sqlcampus.backend.testdata.entities;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Employee {

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

    @Field("salary")
	private int salary;

    @Field("role")
	private String role;

    @Field("salary")
    @DBRef
	private Supermarket supermarket;

}
