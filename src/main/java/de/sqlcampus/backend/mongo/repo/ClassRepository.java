package de.sqlcampus.backend.mongo.repo;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClassRepository extends MongoRepository<de.sqlcampus.backend.mongo.entities.Class, UUID>{

}
