package com.example.mapstruct;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MapstructApplicationTests {

    @Test
    void contextLoads() {

        UserVo userVo = new UserVo();
        userVo.setId(1);
        userVo.setUsername("weizihan");

        User user = UserConvert.INSTANCE.convert(userVo);
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getRealname());
    }

}
