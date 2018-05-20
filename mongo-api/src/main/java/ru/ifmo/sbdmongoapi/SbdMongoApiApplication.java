package ru.ifmo.sbdmongoapi;

import com.mongodb.MongoClientURI;
import com.mongodb.ReadPreference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;


@SpringBootApplication
public class SbdMongoApiApplication {

    public @Bean
    MongoTemplate mongoTemplate() {
        MongoTemplate mongoTemplate  = new MongoTemplate(new SimpleMongoDbFactory(new MongoClientURI("mongodb://localhost:3003,localhost:3001,localhost:3002/database")));
        mongoTemplate.setReadPreference(ReadPreference.secondary());
        return mongoTemplate;
    }

	public static void main(String[] args) {
		SpringApplication.run(SbdMongoApiApplication.class, args);
	}
}
