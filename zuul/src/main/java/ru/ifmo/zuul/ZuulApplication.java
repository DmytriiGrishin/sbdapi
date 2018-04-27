package ru.ifmo.zuul;

import com.netflix.client.http.HttpRequest;
import io.dummymaker.export.IExporter;
import io.dummymaker.export.impl.JsonExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
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
		HttpRequest httpRequest = new HttpRequest.Builder().header("Content-Type", "application/json").build();
        GenMongo genMongoResponseEntity = new GenMongo();
        String exportAsString = "ERROR";
		for(int i = 0; i < count; i ++) {
            List<GenMongo> generated = dataGenerator.generateObject(GenMongo.class, 1);
            exportAsString = exporter.exportAsString(generated);
            genMongoResponseEntity = restTemplate.postForObject("http://mongo-api/forms", httpRequest, GenMongo.class, exportAsString);
        }
        return exportAsString;
	}



    @RequestMapping(value = "/gencasandra")
    public @ResponseBody String gencasandra(@RequestParam Integer count){
        HttpRequest httpRequest = new HttpRequest.Builder().header("Content-Type", "application/json").build();
        GenCassandra genMongoResponseEntity = new GenCassandra();
        String exportAsString = "";
        for(int i = 0; i < count; i ++) {
            List<GenCassandra> generated = dataGenerator.generateObject(GenCassandra.class, 1);
            exportAsString = exporter.exportAsString(generated);
            genMongoResponseEntity = restTemplate.postForObject("http://sidecar/cassandra/insert", httpRequest, GenCassandra.class, exportAsString);
        }
        return exportAsString;
    }

	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
	}
}
