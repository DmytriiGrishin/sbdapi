package ru.ifmo.sbdmongoapi;

import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class SbdMongoApiApplication {

    @Bean
    public DataFactory dataFactory(){
        DataFactory dataFactory = new DataFactory();
        return dataFactory;
    }

	public static void main(String[] args) {
		SpringApplication.run(SbdMongoApiApplication.class, args);
	}
}
