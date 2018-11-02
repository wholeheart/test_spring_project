package com.example.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.example.test.dao")
@ImportResource(locations={"classpath:mykaptcha.xml"})
public class TestApplication {

    public static void main(String[] args) {

        SpringApplication.run(TestApplication.class, args);
    }
}
