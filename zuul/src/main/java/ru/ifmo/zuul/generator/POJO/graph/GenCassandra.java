package ru.ifmo.zuul.generator.POJO.graph;

import io.dummymaker.annotation.special.GenEnumerate;
import io.dummymaker.annotation.time.GenDate;
import lombok.Builder;
import lombok.Data;
import ru.ifmo.zuul.generator.POJO.DBObject;
import ru.ifmo.zuul.generator.customAnnotation.annotations.GenLow;
import ru.ifmo.zuul.generator.customAnnotation.annotations.GenReason;

@Data
@Builder
public class GenCassandra {

    private Integer id;
    private String description;
    private String date;
    private String crime;

}
