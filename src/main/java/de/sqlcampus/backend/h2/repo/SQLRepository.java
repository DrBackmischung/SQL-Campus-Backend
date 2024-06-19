package de.sqlcampus.backend.h2.repo;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import de.sqlcampus.backend.h2.entities.SQLResult;

public interface SQLRepository extends JpaRepository<SQLResult, UUID>{
	
	@Query(value = "?1", nativeQuery = true)
	List<Map<String, Object>> executeSQL(String query);

}
