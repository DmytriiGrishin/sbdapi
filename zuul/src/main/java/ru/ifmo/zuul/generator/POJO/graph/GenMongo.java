package ru.ifmo.zuul.generator.POJO.graph;

import io.dummymaker.annotation.special.GenEnumerate;
import io.dummymaker.annotation.string.GenCity;
import io.dummymaker.annotation.string.GenId;
import io.dummymaker.annotation.string.GenName;
import io.dummymaker.annotation.string.GenNoun;
import lombok.Data;
import ru.ifmo.zuul.generator.POJO.DBObject;
import ru.ifmo.zuul.generator.customAnnotation.annotations.GenAge;
import ru.ifmo.zuul.generator.customAnnotation.annotations.GenGender;
import ru.ifmo.zuul.generator.customAnnotation.annotations.GenReason;

@Data
public class GenMongo implements DBObject {
    @GenEnumerate
    private Integer id;

    @GenName
    private String name;

    @GenGender
    private String gender;

    @GenAge
    private Integer age;

    @Override
    public Integer getId() {
        return id;
    }

    @GenNoun
    private String taken;

    @GenNoun
    private String left;

    @GenCity
    private String destination;

    @GenReason
    private String reason;

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public Integer getAge() {
        return age;
    }

    public String getTaken() {
        return taken;
    }

    public String getLeft() {
        return left;
    }

    public String getDestination() {
        return destination;
    }

    public String getReason() {
        return reason;
    }


}
