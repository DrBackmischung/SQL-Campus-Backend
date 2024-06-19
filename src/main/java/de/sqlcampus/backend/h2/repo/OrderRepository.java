package de.sqlcampus.backend.h2.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import de.sqlcampus.backend.h2.entities.Order;

public interface OrderRepository extends JpaRepository<Order, UUID>{

}
