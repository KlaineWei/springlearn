package com.example.listtotree;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootTest
public class PlatformTest {

    private final List<Platform> platformList = Lists.newArrayList();
    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    private void init(){
        Platform platform0 = new Platform("1","001","0","集团");
        Platform platform1 = new Platform("2","QYPT001","1","销委会");
        Platform platform2 = new Platform("3","QYPT002","2","吉龙大区");
        Platform platform3 = new Platform("4","QYPT003","2","江苏大区");
        Platform platform4 = new Platform("5","QYPT004","4","南京分区");

        Platform platform5 = new Platform("6","QYPT005","1","教育BG");
        Platform platform6 = new Platform("7","QYPT006","6","华南大区");
        Platform platform7 = new Platform("8","QYPT007","6","华东大区");

        platformList.add(platform0);
        platformList.add(platform1);
        platformList.add(platform2);
        platformList.add(platform3);
        platformList.add(platform4);
        platformList.add(platform5);
        platformList.add(platform6);
        platformList.add(platform7);
    }

    @SneakyThrows
    @Test
    public void test1(){
        System.out.println(platformList.size());
        Long startTime = System.currentTimeMillis();
        List<Platform> result = Lists.newArrayList();
        for (Platform platform : platformList) {

            //获取根节点
            if(platform.getParentId().equals("0")){
                result.add(platform);
            }

            for(Platform child : platformList){
                if(child.getParentId().equals(platform.getId())){
                    platform.addChild(child);
                }
            }
        }
        Long endTime = System.currentTimeMillis();
        Long cost = endTime-startTime;
        System.out.println(cost);

        System.out.println(objectMapper.writeValueAsString(result));
    }

    @SneakyThrows
    @Test
    public void test2(){
        Map<String, List<Platform>> platformMap = new HashMap<>();
        Long startTime = System.currentTimeMillis();

        platformList.forEach(platform -> {
            List<Platform> children = platformMap.getOrDefault(platform.getParentId(), new ArrayList<>());
            children.add(platform);
            platformMap.put(platform.getParentId(),children);
        });

        platformList.forEach(platform -> platform.setChildren(platformMap.get(platform.getId())));

        List<Platform> result = platformList.stream().filter(v -> v.getParentId().equals("0")).collect(Collectors.toList());

        Long endTime = System.currentTimeMillis();
        Long cost = endTime-startTime;
        System.out.println(cost);
        System.out.println(objectMapper.writeValueAsString(result));

    }

    @SneakyThrows
    @Test
    public void test3(){
        Long startTime = System.currentTimeMillis();
        Map<String, List<Platform>> groupMap = platformList.stream().collect(Collectors.groupingBy(Platform::getParentId));
        platformList.forEach(platform -> platform.setChildren(groupMap.get(platform.getId())));
        List<Platform> collect = platformList.stream()
                .filter(platform -> platform.getParentId().equals("0")).collect(Collectors.toList());

        Long endTime = System.currentTimeMillis();
        Long cost = endTime-startTime;
        System.out.println(cost);
        System.out.println(objectMapper.writeValueAsString(collect));
    }
}
