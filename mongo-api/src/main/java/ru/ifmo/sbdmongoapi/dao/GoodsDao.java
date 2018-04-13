package ru.ifmo.sbdmongoapi.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.ifmo.sbdmongoapi.model.Goods;

public interface GoodsDao extends MongoRepository<Goods, String> {
}
