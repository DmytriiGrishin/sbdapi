package ru.ifmo.zuul.generator.POJO.graph;

import io.dummymaker.annotation.special.GenEnumerate;
import io.dummymaker.annotation.string.GenName;
import lombok.Builder;
import lombok.Data;
import ru.ifmo.zuul.generator.POJO.DBObject;
import ru.ifmo.zuul.generator.customAnnotation.annotations.GenLow;
import ru.ifmo.zuul.generator.customAnnotation.annotations.GenReason;
import ru.ifmo.zuul.generator.customAnnotation.annotations.GenType;

@Data
@Builder
public class GenNeo4j {

    private String name;
}
