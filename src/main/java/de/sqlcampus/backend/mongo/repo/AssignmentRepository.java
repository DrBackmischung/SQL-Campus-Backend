package de.sqlcampus.backend.mongo.repo;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import de.sqlcampus.backend.mongo.entities.Assignment;

public interface AssignmentRepository extends MongoRepository<Assignment, UUID>{

}
