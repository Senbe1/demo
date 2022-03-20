package com.example.demo.springbootdemo.service.impl;

import com.example.demo.springbootdemo.dao.UserMapper;
import com.example.demo.springbootdemo.domain.entity.UserEntity;
import com.example.demo.springbootdemo.service.TestService;
import com.sun.istack.internal.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class TestServiceImpl implements TestService {

    public static Logger logger = Logger.getLogger(TestServiceImpl.class);
    @Autowired
    UserMapper userMapper;

    @Override
    public void addUser(UserEntity user) {
        try {
            userMapper.insert(user);
        }catch (Exception e){
            logger.warning("数据库插入数据异常");
        }
    }

    @Override
    public int delUser(UserEntity user) {
        try {
            int i = userMapper.deleteById(user);
            return i;
        }catch (Exception e){
            logger.warning("数据库删除异常");
        }
        return 0;
    }

    @Override
    public UserEntity queryById(Long id) {
        try {
            UserEntity user = userMapper.unique(id);
            UserEntity user1 = userMapper.single(id);
            return user;
        } catch (Exception e) {
            logger.warning("数据库无法查找到数据");
        }
        return null;
    }

    @Override
    public List<UserEntity> queryByIds(List<Long> ids) {
        try {
            List<UserEntity> list = userMapper.selectByIds(ids);
            return list;
        } catch (Exception e) {
            logger.warning("数据库无法查找到该数据");
        }
        return null;
    }

    @Override
    public int updateById(UserEntity user) {
        try {
            //依据模板更新,只更新属性不为null的值
            int i = userMapper.updateTemplateById(user);

            //所有属性参与更新
            int j = userMapper.updateById(user);

            return i;
        } catch (Exception e) {
            logger.warning("数据库更新异常");
        }
        return 0;
    }

    @Override
    public UserEntity selectByName(String lastName, String firstName) {
        try{
            UserEntity user = userMapper.selectByName(lastName, firstName);
            return user;
        }catch (Exception e){
            logger.warning("数据库查询异常");
        }
        return null;
    }

    @Override
    public int updateAge(int age, Long id) {
        try {
            int i = userMapper.updateAge(age, id);
            return i;
        }catch (Exception e){
            logger.warning("数据库更新异常");
        }
        return 0;
    }


}
