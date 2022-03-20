package com.example.demo.springbootdemo.dao;

import com.example.demo.springbootdemo.domain.entity.UserEntity;
import org.beetl.sql.mapper.BaseMapper;
import org.beetl.sql.mapper.annotation.Select;
import org.beetl.sql.mapper.annotation.Sql;
import org.beetl.sql.mapper.annotation.Update;

public interface UserMapper extends BaseMapper<UserEntity> {
    //根据名称查询
    @Sql("select * from user where lastName=? and firstName=?")
    @Select
    UserEntity selectByName(String lastName, String firstName) ;

    @Sql("update user set age = ? where id = ?")
    @Update
    int updateAge(int age,Long id);
}
