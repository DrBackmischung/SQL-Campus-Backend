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

	public Order(String id, Date date, Time time, int discount, Supermarket supermarket, Customer customer,
			Employee employee, int total, int totalVat) {
		super();
		this.id = id;
		this.date = date;
		this.time = time;
		this.discount = discount;
		this.supermarket = supermarket;
		this.customer = customer;
		this.employee = employee;
		this.total = total;
		this.totalVat = totalVat;
	}
	
	public Order() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public Supermarket getSupermarket() {
		return supermarket;
	}

	public void setSupermarket(Supermarket supermarket) {
		this.supermarket = supermarket;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	public void addItem(Item item) {
		this.items.add(item);
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getTotalVat() {
		return totalVat;
	}

	public void setTotalVat(int totalVat) {
		this.totalVat = totalVat;
	}

}
