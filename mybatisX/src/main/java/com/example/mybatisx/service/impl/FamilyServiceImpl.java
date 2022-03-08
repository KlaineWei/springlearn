package com.example.mybatisx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatisx.entity.Family;
import com.example.mybatisx.service.FamilyService;
import com.example.mybatisx.mapper.FamilyMapper;
import org.springframework.stereotype.Service;

/**
* @author weizihan
* @description 针对表【family】的数据库操作Service实现
* @createDate 2022-03-08 10:46:56
*/
@Service
public class FamilyServiceImpl extends ServiceImpl<FamilyMapper, Family>
    implements FamilyService{

}




