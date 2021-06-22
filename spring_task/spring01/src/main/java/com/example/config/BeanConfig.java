package com.example.config;

import com.example.domain.Person;
import com.example.domain.Wife;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AliasFor;

/**
 * bean 配置类
 * @author licc
 * @date 2021/05/25
 */
@Configuration
public class BeanConfig {

    @Bean(autowireCandidate = false , name = "person")
    public Person getPerson(){
        return new Person();
    }

}
