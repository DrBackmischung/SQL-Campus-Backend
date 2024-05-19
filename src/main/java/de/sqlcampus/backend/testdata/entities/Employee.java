package de.sqlcampus.backend.testdata.entities;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Employee {

    @Field("name")
	private String name;

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

}
