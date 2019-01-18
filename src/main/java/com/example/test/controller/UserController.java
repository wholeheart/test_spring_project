package com.example.test.controller;

import com.example.test.dao.UserMapper;
import com.example.test.entity.User;
import com.example.test.utils.ResponseCode;
import com.example.test.utils.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: test
 * @description:
 * @author: tankyx
 * @create: 2018-11-05 12:02
 **/
@RestController
@RequestMapping(value = "/user",produces = "application/json;charset=utf-8")
public class UserController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping("/list")
    @ResponseBody
    public String list(){
        ResponseObject data0 = new ResponseObject();
        try {
            List<User> list = userMapper.list();
            data0.setCode(ResponseCode.HTTP_SUCCESS);
            data0.setData(list);
        }catch (Exception e){
            data0.setCode(ResponseCode.HTTP_EXCEPTION);
        }
        return ResponseObject.genObj(data0);
    }

}
