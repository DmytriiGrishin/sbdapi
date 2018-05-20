package ru.ifmo.sbdmongoapi.dao.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.ScriptOperations;
import org.springframework.stereotype.Repository;
import ru.ifmo.sbdmongoapi.dao.FormDaoCustom;
import ru.ifmo.sbdmongoapi.model.Form;


@Repository
public class FormDaoImpl  implements FormDaoCustom{


    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Form findFormById(String id) {
        ScriptOperations defaultScriptOperations = mongoTemplate.scriptOps();
        return (Form)defaultScriptOperations.call("findFormById", id);
    }
}
