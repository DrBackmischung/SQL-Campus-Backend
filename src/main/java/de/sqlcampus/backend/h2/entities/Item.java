package de.sqlcampus.backend.h2.entities;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Item {

    @Field("name")
	private String name;

    @Field("description")
	private String description;

    @Field("price")
	private int price;

    @Field("brand")
    @DBRef
	private Brand brand;

    @Field("vat")
	private int vat;

    @Field("purchasingPrice")
	private String purchasingPrice;

}
