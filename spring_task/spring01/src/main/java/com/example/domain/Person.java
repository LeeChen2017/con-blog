package com.example.domain;

import java.util.List;
import java.util.Map;

/**
 * 复杂数据类型依赖注入
 * @author licc
 *
 */
public class Person {

    private Long id;

    private String name;

    private List<String> hobbies;

    private Wife wife;

    private Map<String , String> linkJob;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }


    public Map<String, String> getLinkJob() {
        return linkJob;
    }

    public void setLinkJob(Map<String, String> linkJob) {
        this.linkJob = linkJob;
    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hobbies=" + hobbies +
                ", wife=" + wife +
                ", linkJob=" + linkJob +
                '}';
    }
}
