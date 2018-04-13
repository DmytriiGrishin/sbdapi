package ru.ifmo.sbdmongoapi.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Goods")
public class Goods {
    @Id
    private ObjectId id;

    private String[] taken;

    private String[] left;


}
