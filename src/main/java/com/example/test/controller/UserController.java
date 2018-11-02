package com.example.test.controller;

import com.example.test.dao.UserMapper;
import com.example.test.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: testdemo
 * @description: 用户cotroller
 * @author: tankyx
 * @create: 2018-10-30 15:03
 **/
@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "cs1")
    public void  insert(User user){
        userMapper.insert(user);
    }

    @RequestMapping(value = "/cs")
    public User  selectUserByName(){
       return userMapper.selectUserByName("mark");
    }
}
