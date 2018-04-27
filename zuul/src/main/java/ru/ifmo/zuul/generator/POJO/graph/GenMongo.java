package ru.ifmo.zuul.generator.POJO.graph;

import io.dummymaker.annotation.special.GenEnumerate;
import io.dummymaker.annotation.string.GenCity;
import io.dummymaker.annotation.string.GenName;
import io.dummymaker.annotation.string.GenNoun;
import ru.ifmo.zuul.generator.POJO.DBObject;
import ru.ifmo.zuul.generator.customAnnotation.annotations.GenAge;
import ru.ifmo.zuul.generator.customAnnotation.annotations.GenGender;
import ru.ifmo.zuul.generator.customAnnotation.annotations.GenReason;

public class GenMongo implements DBObject {
    @GenEnumerate(from = 1)
    private Integer id;

    @GenName
    private String name;

    @GenGender
    private String gender;

    @GenAge
    private Integer age;

    @GenNoun
    private String taken;

    @GenNoun
    private String left;

    @GenCity
    private String destination;

    @GenReason
    private String reason;

    @Override
    public Integer getId() {
        return id;
    }
}
