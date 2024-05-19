package de.sqlcampus.backend.repo;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import de.sqlcampus.backend.entities.Assignment;

public interface AssignmentRepository extends MongoRepository<Assignment, UUID>{

}
