package com.example.mybatisx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.mybatisx.mapper")
public class MybatisXApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisXApplication.class, args);
    }

}
