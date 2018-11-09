package com.example.test.controller;

import com.example.test.dao.AdminMapper;
import com.example.test.entity.Admin;
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
public class AdminController {

    @Autowired
    AdminMapper adminMapper;

    @RequestMapping(value = "cs1")
    public void  insert(Admin admin){
        adminMapper.insert(admin);
    }

    @RequestMapping(value = "/cs")
    public Admin selectUserByName(){
       return adminMapper.selectAdminByName("mark");
    }
}
