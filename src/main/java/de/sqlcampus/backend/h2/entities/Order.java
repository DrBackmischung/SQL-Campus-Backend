package de.sqlcampus.backend.h2.entities;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="order")
public class Order {

    @Id   
	@Column
    private String id;  

	@Column
	private Date date;

	@Column
	private Time time;

	@Column
	private int discount;

    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name = "supermarket", referencedColumnName = "id")
	private Supermarket supermarket;

    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name = "customer", referencedColumnName = "id")
	private Customer customer;

    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name = "employee", referencedColumnName = "id")
	private Employee employee;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "orders")
	private List<Item> items;

	@Column
	private int total;

	@Column
	private int totalVat;

}
