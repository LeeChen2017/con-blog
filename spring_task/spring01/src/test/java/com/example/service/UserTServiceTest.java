package com.example.service;


import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserTServiceTest {

    @Test
    public void test1(){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-tx.xml");
        UserTService bean = context.getBean(UserTService.class);
        bean.updateUserByRole(4L , 2);
    }

}
