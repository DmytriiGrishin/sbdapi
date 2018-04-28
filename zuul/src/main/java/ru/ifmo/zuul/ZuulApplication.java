package ru.ifmo.zuul;

import com.netflix.client.http.HttpRequest;
import io.dummymaker.export.IExporter;
import io.dummymaker.export.impl.JsonExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.ifmo.zuul.generator.DataGenerator;
import ru.ifmo.zuul.generator.POJO.graph.GenCassandra;
import ru.ifmo.zuul.generator.POJO.graph.GenMongo;

import java.util.List;

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

    private IExporter exporter = new JsonExporter();

	@RequestMapping(value = "/genmongo")
	public @ResponseBody String genmongo(@RequestParam Integer count){
        GenMongo genMongoResponseEntity = new GenMongo();
        String exportAsString = "ERROR";
        List<GenMongo> generated = dataGenerator.generateObject(GenMongo.class, count);
        exportAsString = exporter.exportAsString(generated);
        generated.forEach(v -> {
            HttpRequest httpRequest = new HttpRequest.Builder()
                    .header("Content-Type", "application/json")
                    .uri("http://mongo-api/forms")
                    .build();
            restTemplate.postForObject("http://mongo-api/forms", v, GenMongo.class);
        });
        return exportAsString;
	}



    @RequestMapping(value = "/gencasandra")
    public @ResponseBody String gencasandra(@RequestParam Integer count){
        GenCassandra genMongoResponseEntity = new GenCassandra();
        String exportAsString = "";
        List<GenCassandra> generated = dataGenerator.generateObject(GenCassandra.class, count);
        exportAsString = exporter.exportAsString(generated);
        generated.forEach(v -> {
            HttpRequest httpRequest = new HttpRequest.Builder().header("Content-Type", "application/json").build();
            restTemplate.postForObject("http://localhost:8542/cassandra/insert", v, GenCassandra.class);
        });
        return exportAsString;
    }

	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
	}
}
