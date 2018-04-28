package ru.ifmo.sbdmongoapi.dao.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.ScriptOperations;
import ru.ifmo.sbdmongoapi.dao.FormDao;
import ru.ifmo.sbdmongoapi.dao.FormDaoCustom;
import ru.ifmo.sbdmongoapi.model.Form;

public class FormDaoImpl  implements FormDaoCustom{

    @Autowired
    FormDao formDao;

    @Override
    public Long averageAge() {
        Long count = formDao.count();
        Long sum = formDao.findAll().stream()
                                    .map(Form::getAge)
                                    .map(Long::new)
                                    .reduce(0L, (a, b) -> a + b);
        return sum/count;
    }

    @Autowired
    ScriptOperations scriptOperations;

    @Override
    public Form findFormById(String id) {
        return (Form)scriptOperations.call("findFormById", id);
    }
}
