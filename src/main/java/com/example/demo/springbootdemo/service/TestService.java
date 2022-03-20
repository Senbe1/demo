package com.example.demo.springbootdemo.service;

import com.example.demo.springbootdemo.domain.entity.UserEntity;
import org.beetl.sql.mapper.annotation.Select;
import org.beetl.sql.mapper.annotation.Sql;

import java.util.List;

public interface TestService {

    //新增
    void addUser(UserEntity user);

    //根据主键删除
    int delUser(UserEntity user);

    //根据主键查单条
    UserEntity queryById(Long id);

    //根据主键数组查所有
    List<UserEntity>  queryByIds(List<Long> ids);

    //根据主键更新
    int updateById(UserEntity user);

   //根据姓名城查询
    UserEntity selectByName(String lastName,String firstName);

    //根据主键,更新年龄
    int updateAge(int age, Long id);
}
