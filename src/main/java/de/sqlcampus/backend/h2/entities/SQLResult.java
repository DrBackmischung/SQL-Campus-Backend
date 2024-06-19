package de.sqlcampus.backend.h2.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="result")
public class SQLResult {
	
	@Id
	@Column
	private String id;

}
