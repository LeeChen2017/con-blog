package com.example.domain;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * IOC test
 */
public class TestIoc {

    public ApplicationContext applicationContext ;

    @Before
    public void before(){
        //初始化容器 ，使用xml 配置的方式实现 ，初始化容器有三种方式：1、基于xml文件配置 2、基于 注解方式（一般不单独使用） 3、 基于javaConfig方式
        //测试案例使用第一种 方式,并支持多个xml 文件初始化
        //ClassPathXmlApplicationContext 是从项目根目录中查找这个xml文件
        //
        applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        //FileSystemXmlApplicationContext 基于文件系统进行初始化 容器
    }


    @Test
    public void test(){



        User bean = applicationContext.getBean(User.class);
        //
        User user = (User) applicationContext.getBean("user");

        //使用别名
        User user2 = (User)applicationContext.getBean("userContainer");
        System.out.println(user2);

    }

    /**
     * 基于构造函数的方式依赖注入bean
     */
    @Test
    public void test2(){
        User user3 = (User) applicationContext.getBean("user3");
        System.out.println(user3);
    }

    @Test
    public void test3(){
        User user = (User)applicationContext.getBean("user4");
        System.out.println(user);
    }

    /**
     * 使用p:命名空间
     */
    @Test
    public void test4(){
       Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);
    }

    @Test
    public void test5(){
        Wife person = (Wife) applicationContext.getBean("wife2");
        System.out.println(person);
    }

}
