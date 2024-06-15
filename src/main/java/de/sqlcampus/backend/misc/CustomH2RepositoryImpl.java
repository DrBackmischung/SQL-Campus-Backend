package de.sqlcampus.backend.misc;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import jakarta.persistence.EntityManager;

public class CustomH2RepositoryImpl<T extends UuidIdentifiedEntity> extends SimpleJpaRepository<T, UUID> implements CustomH2Repository<T> {
    
    public CustomH2RepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		// TODO Auto-generated constructor stub
	}

	@Override
    public <S extends T> S save(S entity) {
        generateId(entity);
        return super.save(entity);
    }

    @Override
    public <S extends T> List<S> saveAll(Iterable<S> entities) {
        entities.forEach(entity -> generateId(entity));
        return super.saveAll(entities);
    }

    protected <S extends T> void generateId(S entity) {
        
        if(entity != null && entity.getId() == null) {
            entity.setId(UUID.randomUUID());
        }
    }

}
