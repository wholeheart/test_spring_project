package com.example.test.dao;

import com.example.test.entity.Admin;
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
public interface AdminMapper {
    void insert(Admin admin);

    Admin selectAdminByName(String username);

}
