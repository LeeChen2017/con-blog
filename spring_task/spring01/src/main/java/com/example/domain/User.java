package com.example.domain;

/**
 * @author licc
 * @date 2021/05/18
 */
public class User {

    private Integer id;

    private String name ;

    private String realName;

    public User() {
        System.out.println("user bean 已加载！");
    }

    public User(Integer id, String name, String realName) {
        this.id = id;
        this.name = name;
        this.realName = realName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", realName='" + realName + '\'' +
                '}';
    }
}
