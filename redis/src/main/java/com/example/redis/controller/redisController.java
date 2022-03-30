package com.example.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.BitFieldSubCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("redis")
public class redisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/getBit")
    public Boolean getBit(){

        Boolean existFlag = redisTemplate.hasKey("weizh");  //查看key为weizh的记录是否存在
        redisTemplate.opsForValue().setBit("weizh", 1, true );   //给key为"weizh"的1000位置1
        redisTemplate.opsForValue().setBit("weizh",2,true);
        redisTemplate.opsForValue().setBit("weizh",10,true);
        Boolean flag = redisTemplate.opsForValue().getBit("weizh", 1);  //查询key为"weizh"的1000位置值
//        Long weizh = redisTemplate.getExpire("weizh");   //获取过期时间，如果没有设置，则为-1，永远不会过期
        redisTemplate.expire("weizh", 10, TimeUnit.MINUTES);  //设置过期时间
        Long weizh1 = redisTemplate.getExpire("weizh");  //获取过期时间
//        System.out.println(weizh);
        System.out.println(weizh1);
//        redisTemplate.delete("weizh");   //删除key为"weizh"的记录
        Object weizh2 = redisTemplate.opsForValue().get("weizh");
        System.out.println(weizh2);
        return flag;
    }

    @GetMapping("/getBitField")
    public void getBitField(){
        String key = "test";
        Integer insertions = 1000;
        List<Integer> offset = new ArrayList<>();
        for (int i = 0; i < insertions; i++) {
            offset.add(i);
        }
        Long startTime = System.currentTimeMillis();
        BitFieldSubCommands commands = BitFieldSubCommands.create();// 使用合并写法,假设10万条数据一个for需要12秒
        for (int i : offset) {
            commands = commands.set(BitFieldSubCommands.BitFieldType.unsigned(1)).valueAt(i).to(1);// 合并bit
        }
        redisTemplate.opsForValue().bitField(key, commands);// 再一次写入redis
        Long endTime = System.currentTimeMillis();
        Long costTime = endTime-startTime;
        System.out.println("bitfield cost: " + costTime);
        String key2 = "test2";
        Long startTime2 = System.currentTimeMillis();
        for (int i : offset) {
            redisTemplate.opsForValue().setBit(key2, i, true);
        }
        Long endTime2 = System.currentTimeMillis();
        Long costTime2 = endTime2-startTime2;
        System.out.println("bitset cost: " + costTime2);
    }

    @GetMapping("/srt")
    public void srt(){
        String key = "test";
        for (int i = 0; i < 10; i++) {
            stringRedisTemplate.opsForValue().setBit(key,i,true);
        }

        System.out.println(stringRedisTemplate.opsForValue().get(key));
    }
}
