package de.sqlcampus.backend.h2.entities;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class OrderItem {

    @Field("quantity")
	private int quantity;

    @Field("order")
    @DBRef
	private Order order;

    @Field("item")
    @DBRef
	private Item item;

    @Field("total")
	private int total;

    @Field("totalVat")
	private int totalVat;

}
