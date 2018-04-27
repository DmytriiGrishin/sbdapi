package ru.ifmo.zuul;

import com.netflix.client.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.ifmo.zuul.generator.DataGenerator;
import ru.ifmo.zuul.generator.POJO.graph.GenMongo;

@SpringBootApplication
@RestController
@EnableZuulProxy
public class ZuulApplication {

	@LoadBalanced
	@Bean
	RestTemplate restTemplate(){
		return new RestTemplate();
	}

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	DataGenerator dataGenerator;

	@RequestMapping(value = "/genmongo")
	public void genmongo(@RequestParam Integer count){
		HttpRequest httpRequest = new HttpRequest.Builder().header("Content-Type", "application/json").build();
			restTemplate.postForObject("http://mongo-api/forms", httpRequest, GenMongo.class, dataGenerator.generateObject(GenMongo.class, count));
	}

	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
	}
}
