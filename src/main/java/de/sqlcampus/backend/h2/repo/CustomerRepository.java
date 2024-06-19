package de.sqlcampus.backend.h2.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import de.sqlcampus.backend.h2.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, UUID>{

}
