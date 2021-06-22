package com.example.service;

import com.example.domain.Person;
import com.example.domain.Wife;

/**
 * BeanFactory
 * @author licc
 *
 */
public class ServiceLocator {

    public static Person person = new Person();

    public static Wife wife = new Wife();

    public Person getPerson(){
        return person;
    }

    public Wife getWife(){
        return wife;
    }

}
