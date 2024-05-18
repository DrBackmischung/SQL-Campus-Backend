package de.sqlcampus.backend.repo;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import de.sqlcampus.backend.entities.User;

public interface UserRepository extends MongoRepository<User, UUID>{

	Optional<User> findByEmail(String email);

}
