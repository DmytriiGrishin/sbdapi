package ru.ifmo.zuul;

import com.netflix.client.http.HttpRequest;
import io.dummymaker.export.IExporter;
import io.dummymaker.export.impl.JsonExporter;
import jdk.nashorn.internal.parser.JSONParser;
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
import ru.ifmo.zuul.generator.POJO.graph.GenNeo4j;

import java.util.HashMap;
import java.util.LinkedHashMap;
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
	DataGenerator dataGenerator;

    private IExporter exporter = new JsonExporter();

	@RequestMapping(value = "/genmongo")
	public @ResponseBody String genmongo(@RequestParam Integer count){
		RestTemplate restTemplate = new RestTemplate();
        GenMongo genMongoResponseEntity = new GenMongo();
        String exportAsString = "ERROR";
        List<GenMongo> generated = dataGenerator.generateObject(GenMongo.class, count);
        exportAsString = exporter.exportAsString(generated);
        generated.forEach(v -> {
            restTemplate.postForObject("http://localhost:8080/forms", v, GenMongo.class);
        });
        return exportAsString;
	}


	@RequestMapping(value = "/select")
	public @ResponseBody String selectFromAll(@RequestParam Integer id){
		String jenyaUri = "http://192.168.43.212:9000/";
		RestTemplate restTemplate = new RestTemplate();
		List<LinkedHashMap> genCassandra =  restTemplate.postForObject(jenyaUri +"cassandra/select", GenCassandra.builder().id(id).build(), List.class);
		restTemplate = new RestTemplate();
		GenMongo genMongo = restTemplate.getForObject("http://localhost:8080/forms/" + id, GenMongo.class);
        genMongo.setId(id);



        List<LinkedHashMap>  what_can_do =  restTemplate.postForObject(jenyaUri +"neo4j/select/what_can_do", GenNeo4j.builder().name(id.toString()).build(),  List.class);
        List<LinkedHashMap>  what_done =  restTemplate.postForObject(jenyaUri +"neo4j/select/what_already_done", GenNeo4j.builder().name(id.toString()).build(),  List.class);
        return "[" + new JsonExporter().exportAsString(genMongo) +","+ genCassandra.get(0).toString()+ ","+ what_can_do + ","+ what_done + "]";
	}

	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
	}
}
