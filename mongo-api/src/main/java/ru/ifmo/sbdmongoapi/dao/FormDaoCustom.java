package ru.ifmo.sbdmongoapi.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.ifmo.sbdmongoapi.model.Form;

public interface FormDaoCustom {
    @RequestMapping("averageAge")
    public Long averageAge();

    @RequestMapping("findById")
    public Form findById(@RequestAttribute String id);

}
