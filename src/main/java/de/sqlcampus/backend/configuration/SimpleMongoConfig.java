package de.sqlcampus.backend.configuration;

import org.bson.UuidRepresentation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import de.sqlcampus.backend.misc.CustomMongoRepositoryImpl;

@Configuration
@EnableMongoRepositories(basePackages = "de.sqlcampus.backend.mongo.repo", repositoryBaseClass = CustomMongoRepositoryImpl.class)
public class SimpleMongoConfig {
 
    @Bean
    public MongoClient mongo() {
        ConnectionString connectionString = new ConnectionString("mongodb+srv://admin:MongoDBAdmin@mathisneunzig.gxcl7jz.mongodb.net/?retryWrites=true&w=majority");
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
          .uuidRepresentation(UuidRepresentation.STANDARD)
          .applyConnectionString(connectionString)
          .build();
        
        return MongoClients.create(mongoClientSettings);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), "test");
    }
    
//    @Bean
//    public UuidIdentifiedEntityEventListener uuidIdentifiedEntityEventListener() {
//        return new UuidIdentifiedEntityEventListener();
//    }
    
//    @Bean
//    public BeforeConvertCallback<UuidIdentifiedEntity> beforeSaveCallback() {
//        
//        return (entity, collection) -> {
//              
//            if (entity.getId() == null) {
//                entity.setId(UUID.randomUUID());
//            }
//            return entity;
//        };
//    }
    
}