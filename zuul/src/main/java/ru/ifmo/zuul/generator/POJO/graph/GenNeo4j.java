package ru.ifmo.zuul.generator.POJO.graph;

import io.dummymaker.annotation.special.GenEnumerate;
import io.dummymaker.annotation.string.GenName;
import ru.ifmo.zuul.generator.POJO.DBObject;
import ru.ifmo.zuul.generator.customAnnotation.annotations.GenLow;
import ru.ifmo.zuul.generator.customAnnotation.annotations.GenReason;
import ru.ifmo.zuul.generator.customAnnotation.annotations.GenType;

public class GenNeo4j implements DBObject {

    @GenEnumerate(from = 1)
    private Integer id;

    @GenName
    private String name;

    @GenLow
    private String low;

    @GenType
    private String action_type;

    @GenReason
    private String reason;

    @Override
    public Integer getId() {
        return id;
    }
}
