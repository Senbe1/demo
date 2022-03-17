package com.example.demo.springbootdemo.controller;

import com.example.demo.springbootdemo.domain.entity.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/test/")
public class TestController {

    @Resource

    public void addUser(UserEntity user){

    }

}
