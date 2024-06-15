package de.sqlcampus.backend.h2.entities;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Order {

    @Field("date")
	private Date date;

    @Field("time")
	private Time time;

    @Field("discount")
	private int discount;

    @Field("supermarket")
    @DBRef
	private Supermarket supermarket;

    @Field("customer")
    @DBRef
	private Customer customer;

    @Field("employee")
    @DBRef
	private Employee employee;

    @Field("items")
    @DBRef
	private List<OrderItem> items;

    @Field("total")
	private int total;

    @Field("totalVat")
	private int totalVat;

}
