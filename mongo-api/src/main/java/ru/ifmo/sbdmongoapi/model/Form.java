package ru.ifmo.sbdmongoapi.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Builder
@Document(collection = "Forms")
@AllArgsConstructor
@NoArgsConstructor
public class Form {
    @Id
    private ObjectId id;

    private String name;

    private Gender gender;

    private String left;

    private String taken;

    private int age;

    private String destination;

    private String[] reasons;

}
