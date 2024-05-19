package de.sqlcampus.backend.repo;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import de.sqlcampus.backend.entities.Course;

public interface CourseRepository extends MongoRepository<Course, UUID>{

}
