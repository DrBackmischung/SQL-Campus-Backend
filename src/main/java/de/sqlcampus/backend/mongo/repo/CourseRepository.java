package de.sqlcampus.backend.mongo.repo;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import de.sqlcampus.backend.mongo.entities.Course;

public interface CourseRepository extends MongoRepository<Course, UUID>{

}
