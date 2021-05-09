package com.example.jpa.demo.exp1;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class User {

    @Id
    private Integer id;

    private String name;

    private String emailAddress;

    private Integer age;

    private String address;

}
