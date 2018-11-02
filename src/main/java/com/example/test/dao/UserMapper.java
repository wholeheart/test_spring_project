package com.example.test.dao;

import com.example.test.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @program: testdemo
 * @description:
 * @author: tankyx
 * @create: 2018-10-30 15:33
 **/
@Mapper
@Repository
public interface UserMapper {
    void insert(User user);

    User selectUserByName(String username);

}
