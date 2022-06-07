package com.example.elasticsearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author weizihan
 */
@RestController
public class ItemController {

    @Autowired
    private ItemRepo itemRepo;

    @PostMapping("/item")
    public void addItem(@RequestBody Item item){
        System.out.println(item);
        itemRepo.save(item);
        Map<String, String> map = new HashMap<>();
        map.put("msg", "ok");
    }
}
