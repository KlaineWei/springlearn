package com.example.mybatisx;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisx.entity.Users;
import com.example.mybatisx.mapper.UsersMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.TimeZone;

@SpringBootTest
class MybatisXApplicationTests {

    private UsersMapper usersMapper;

    @Autowired(required = false)
    public MybatisXApplicationTests(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    @Test
    void contextLoads() {
    }

    @Test
    public void testupdate(){
        Users user = new Users();
        user.setId(1);
//        user.setGender("nan");
        user.setName("hei");
        usersMapper.updateById(user);
    }

    @Test
    public void testLogicDelete(){
//        Users user = new Users();
//        user.setId(3);
//        user.setGender("nv");
//        user.setName("bai");
//        usersMapper.insert(user);

        usersMapper.deleteById(5);
    }

    @Test
    public void testSelect(){
//        Users user = usersMapper.selectById(1);
        List<Users> users = usersMapper.selectList(null);
        System.out.println(users);
    }

    @Test
    public void testPage(){
//        Page<Users> page = new Page<>(1, 2);
//        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
//        IPage<Users> mypage = usersMapper.selectPage(page, queryWrapper);
        LambdaQueryWrapper<Users> usersLambdaQueryWrapper = Wrappers.lambdaQuery();
//        usersLambdaQueryWrapper.like(Users::getName, "l");
        Page<Users> page = new Page<>(1,1);
        Page<Users> mypage = usersMapper.selectPage(page, usersLambdaQueryWrapper);
        System.out.println(mypage.getPages());
        mypage.getRecords().forEach(System.out::println);
    }

}
