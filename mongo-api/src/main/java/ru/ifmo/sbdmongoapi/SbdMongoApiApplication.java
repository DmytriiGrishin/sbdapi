package ru.ifmo.sbdmongoapi;

import com.mongodb.MongoClientURI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;


@SpringBootApplication
public class SbdMongoApiApplication {

    public @Bean
    MongoTemplate mongoTemplate() {
        return new MongoTemplate(new SimpleMongoDbFactory(new MongoClientURI("mongodb://localhost:27017/database")));
    }

	public static void main(String[] args) {
		SpringApplication.run(SbdMongoApiApplication.class, args);
	}
}
