package ru.ifmo.sbdmongoapi.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.ifmo.sbdmongoapi.model.Form;

public interface FormDao extends MongoRepository<Form, String> {
}
