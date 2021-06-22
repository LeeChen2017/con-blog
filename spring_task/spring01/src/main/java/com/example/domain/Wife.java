package com.example.domain;

import org.springframework.stereotype.Component;

import java.beans.ConstructorProperties;

/**
 * @author licc
 *
 */
public class Wife {

    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Wife() {
        System.out.println("wife 已加载");
    }

    public Wife(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Wife{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
