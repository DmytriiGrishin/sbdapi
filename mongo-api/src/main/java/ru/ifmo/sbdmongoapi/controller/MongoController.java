package ru.ifmo.sbdmongoapi.controller;

import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.ifmo.sbdmongoapi.dao.FormDao;
import ru.ifmo.sbdmongoapi.dao.GoodsDao;
import ru.ifmo.sbdmongoapi.model.Form;
import ru.ifmo.sbdmongoapi.model.Gender;
import ru.ifmo.sbdmongoapi.model.Goods;


@Component
public class MongoController {
    @Autowired
    FormDao formDao;

    @Autowired
    GoodsDao goodsDao;

    @Autowired
    DataFactory dataFactory;

    @EventListener(ContextRefreshedEvent.class)
    public void init(){
        String[] taken = {"taken", "all"};
        String[] left = {"left", "none"};

            Goods goods = new Goods().builder().taken(taken).left(left).build();
            goods = goodsDao.save(goods);
            String[] reasons = {dataFactory.getRandomWord()};
            Form form = new Form().builder().name(dataFactory.getName()).age(dataFactory.getNumberBetween(0, 100)).destination(dataFactory.getCity())
                    .gender(Gender.Female).goods(goods).reasons(reasons).build();
            formDao.save(form);

    }
}
