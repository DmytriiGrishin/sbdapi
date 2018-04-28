package ru.ifmo.sbdmongoapi;

import com.mongodb.MongoClient;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;


@SpringBootApplication
public class SbdMongoApiApplication {

    @Bean
    public DataFactory dataFactory(){
        DataFactory dataFactory = new DataFactory();
        return dataFactory;
    }

    @Value("${spring.data.mongodb.uri}")
    private String mongoUrl;

    public @Bean
    MongoClient mongoClient() {
        return new MongoClient(mongoUrl);
    }

    public @Bean
    MongoDbFactory mongoDbFactory() {
        return new SimpleMongoDbFactory(mongoClient(), "database");
    }

	public static void main(String[] args) {
		SpringApplication.run(SbdMongoApiApplication.class, args);
	}
}
