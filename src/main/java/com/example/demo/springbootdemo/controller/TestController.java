package com.example.demo.springbootdemo.controller;

import com.example.demo.springbootdemo.domain.entity.UserEntity;
import com.example.demo.springbootdemo.domain.res.CodeMsg;
import com.example.demo.springbootdemo.service.ITestService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.beetl.sql.ext.DBInitHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/test/")
public class TestController {

    private static final Log log = LogFactory.getLog(TestController.class);

    @Resource
    ITestService testService;

    @RequestMapping("/index")
    public String sayHello(){
        return "index";
    }


    @RequestMapping("addUser")
    public CodeMsg addUser(UserEntity user) {
        try {
            testService.addUser(user);
            return CodeMsg.success(user);
        } catch (Exception e) {
            log.error("添加用户异常");
        }
        return CodeMsg.fail(user);
    }

    @RequestMapping("addUserList")
    public CodeMsg addUserList(List<UserEntity> list) {
        try {
            for (UserEntity it : list) {
                testService.addUser(it);
            }
            String id = UUID.randomUUID().toString().replaceAll("-", " ");

        } catch (Exception e) {

        }
        return CodeMsg.fail();
    }

}
