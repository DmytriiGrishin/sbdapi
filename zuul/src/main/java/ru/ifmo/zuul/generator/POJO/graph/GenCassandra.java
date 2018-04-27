package ru.ifmo.zuul.generator.POJO.graph;

import io.dummymaker.annotation.special.GenEnumerate;
import io.dummymaker.annotation.time.GenDate;
import ru.ifmo.zuul.generator.POJO.DBObject;
import ru.ifmo.zuul.generator.customAnnotation.annotations.GenLow;
import ru.ifmo.zuul.generator.customAnnotation.annotations.GenReason;

public class GenCassandra implements DBObject {
    @GenEnumerate(from = 1)
    private Integer id;

    @GenReason
    private String description;

    @GenDate
    private String date;

    @GenLow
    private String low;

    @Override
    public Integer getId() {
        return id;
    }
}
