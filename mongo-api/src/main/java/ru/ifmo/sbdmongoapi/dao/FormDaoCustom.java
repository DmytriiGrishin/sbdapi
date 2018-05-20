package ru.ifmo.sbdmongoapi.dao;

import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.ifmo.sbdmongoapi.model.Form;

public interface FormDaoCustom {
    @RequestMapping("findFormById")
    public Form findFormById(@RequestAttribute String id);

}
