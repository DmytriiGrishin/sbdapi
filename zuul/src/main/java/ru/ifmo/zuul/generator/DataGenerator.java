package ru.ifmo.zuul.generator;

import io.dummymaker.export.IExporter;
import io.dummymaker.export.impl.JsonExporter;
import io.dummymaker.factory.IProduceFactory;
import io.dummymaker.factory.impl.GenProduceFactory;
import org.springframework.stereotype.Component;
import ru.ifmo.zuul.generator.POJO.DBObject;
import ru.ifmo.zuul.generator.POJO.graph.GenCassandra;
import ru.ifmo.zuul.generator.POJO.graph.GenMongo;
import ru.ifmo.zuul.generator.POJO.graph.GenNeo4j;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataGenerator {

    private final int pigsNumber = 200;

    private final int ageNumber = pigsNumber;
    private final int cityNumber = pigsNumber;
    private final int reasonNumber = pigsNumber;
    private final int genderNum = pigsNumber;

    private final int pigsNameNumber = pigsNumber;
    private final int whatCanDoNumber = pigsNumber;
    private final int whatAlreadyDoneNumber = pigsNumber;
    private final int whyCanDoNumber = pigsNumber;

    private final int idNumber = pigsNumber;
    private final int descriptionNumber = pigsNumber;
    private final int dateNumber = pigsNumber;

    private IProduceFactory factory = new GenProduceFactory();
    private IExporter exporter = new JsonExporter();

    public void generate() {

        /*mongo*/
        generateObject(GenMongo.class, ageNumber);
        generateObject(GenMongo.class, cityNumber);
        generateObject(GenMongo.class, reasonNumber);
        generateObject(GenMongo.class, genderNum);



    }

    public <T extends DBObject> List<T> generateObject(Class<T> tClass, int amount) {
        List<T> tList = factory.produce(tClass, amount);
        return tList;
    }
}
