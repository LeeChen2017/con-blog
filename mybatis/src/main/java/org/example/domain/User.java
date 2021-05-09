package org.example.domain;

import org.apache.ibatis.annotations.AutomapConstructor;

import java.util.Date;

/**
 * 实体对象 ， 当前项目不使用JPA
 * @author licc
 * @date 2021/05/08
 *
 */

public class User extends AbstractEntity{

    private String name;

    private Integer age;

    private String address;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    //@AutomapConstructor
    public User(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public User() {
    }

    //@AutomapConstructor
    public User(Long id , String name , Integer age , String createBy , Date creationTime , String lastModifiedBy  , Date lastModifiedTime) {
        super.setId(id);
        this.name = name;
        this.age = age;
        super.setCreateBy(createBy);
        super.setCreationTime(creationTime);
        super.setLastModifiedBy(lastModifiedBy);
        super.setLastModifiedDate(lastModifiedTime);
    }



    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
