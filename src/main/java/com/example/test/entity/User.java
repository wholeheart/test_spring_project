package com.example.test.entity;

/**
 * @program: testdemo
 * @description:
 * @author: tankyx
 * @create: 2018-10-30 14:53
 **/
public class User {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "user{"+
                "username="+username+"\\"+
                "password="+password + "}";
    }
}
