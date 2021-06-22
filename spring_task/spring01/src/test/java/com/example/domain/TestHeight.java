package com.example.domain;

import com.example.config.BeanConfig;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.xml.ws.Provider;

/**
 * @author licc
 */
public class TestHeight {

    private ApplicationContext applicationContext;

//    @Before
//    public void before(){
//        applicationContext = new ClassPathXmlApplicationContext("spring-height.xml");
//    }


   // @Test
   // public void test1(){
   //     applicationContext.getBean("wife");
    //}

    @Test
    public void test2(){
       // Person bean = applicationContext.getBean(Person.class);
       // System.out.println(bean);
    }

    /**
     * 测试 GenericApplicationContext
     */
    @Test
    public void test3(){
        GenericApplicationContext genericApplicationContext = new GenericXmlApplicationContext("spring-config.xml");

        Object wife = genericApplicationContext.getBean("wife");
        System.out.println(wife);

    }

    @Test
    public void test4(){
        GenericApplicationContext context = new GenericApplicationContext();

        //此处 context 当作父类 BeanDefinitionRegistry 使用
        new XmlBeanDefinitionReader(context).loadBeanDefinitions("spring-config.xml");
        context.refresh();
        Object wife2 = context.getBean("wife2");
        System.out.println(wife2);

        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();


    }

    /**
     * generic a license data
     */
    @Test
    public void test5(){
       // AutowireCapableBeanFactory autowireCapableBeanFactory = applicationContext.getAutowireCapableBeanFactory();

    }

    @Test
    public void test6(){
        AnnotationConfigApplicationContext config = new AnnotationConfigApplicationContext(BeanConfig.class);

        Object person = config.getBean("person");
        System.out.println(person);
    }

//    @Test
////    public void test7(){
////
////        ApplicationContext context = new  ClassPathXmlApplicationContext("spring-config2.xml");
////        Wife bean = context.getBean(Wife.class);
////        Object personFactory = context.getBean("personFactory");
////        System.out.println(personFactory);
////
////    }

    @Test
    public void test7(){

        ApplicationContext applicationContext = new GenericXmlApplicationContext("spring-height.xml");
        Object person = applicationContext.getBean("person");
        System.out.println(person);

    }

    @Test
    public void test8(){
//        Provider<Command> commandProvider;
//
//        AnnotationConfigWebApplicationContext
    }



}
