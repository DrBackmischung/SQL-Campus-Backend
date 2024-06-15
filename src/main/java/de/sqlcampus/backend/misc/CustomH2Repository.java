package de.sqlcampus.backend.misc;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CustomH2Repository<T extends UuidIdentifiedEntity> extends JpaRepository<T, UUID> {

}
