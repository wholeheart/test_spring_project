package com.example.test.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CaptchaImageCreateControllerTest {
    private static CaptchaImageCreateController captchaImageCreateController = new CaptchaImageCreateController();

    @Before
    public void setUp() throws Exception {
        System.out.println("===========before===========");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("=========after=============");
    }

    @Test
    public void count() {
        int sum = captchaImageCreateController.count(2,0);
        System.out.println(sum);
    }
}