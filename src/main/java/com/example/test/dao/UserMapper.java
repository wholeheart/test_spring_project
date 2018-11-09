package com.example.test.dao;

import com.example.test.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: test
 * @description:
 * @author: tankyx
 * @create: 2018-11-05 12:03
 **/
@Mapper
@Repository
public interface UserMapper {

    List<User> list();
}
