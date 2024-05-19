package de.sqlcampus.backend.repo;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResultRepository extends MongoRepository<Boolean, UUID>{
	
}
