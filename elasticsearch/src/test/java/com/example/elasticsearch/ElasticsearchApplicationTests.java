package com.example.elasticsearch;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import java.util.Date;

@SpringBootTest
class ElasticsearchApplicationTests {

    @Autowired
    private ItemRepo itemRepo;

    @Test
    public void insert(){
        Item item = new Item(3L, "小米手机7", "手机", "小米", 2999.00, new Date());
        System.out.println(item);
        itemRepo.save(item);
    }

}
