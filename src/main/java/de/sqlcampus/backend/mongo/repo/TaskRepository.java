package de.sqlcampus.backend.mongo.repo;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import de.sqlcampus.backend.mongo.entities.Task;

public interface TaskRepository extends MongoRepository<Task, UUID>{

}
