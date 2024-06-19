package de.sqlcampus.backend.h2.entities;

import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="item")
public class Item {

    @Id   
	@Column
    private String id;  

	@Column
	private String name;

	@Column
	private String description;

	@Column
	private int price;

    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name = "brand", referencedColumnName = "id")
	private Brand brand;

	@Column
	private int vat;

	@Column
	private String purchasingPrice;

	@ManyToMany()
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	@JoinTable(
			  name = "order_items", 
			  joinColumns = @JoinColumn(name = "item_id"), 
			  inverseJoinColumns = @JoinColumn(name = "order_id"))
	private List<Order> orders;

}
