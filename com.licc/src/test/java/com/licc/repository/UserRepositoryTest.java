package com.licc.repository;

import com.licc.config.JpaConfig;
import com.licc.domain.Role;
import com.licc.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;
import java.util.UUID;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;


    @Test
    public void testSave(){

        User user = new User();
        user.setUsername("licc0907");
        userRepository.save(user);
        // System.out.println(dataSource);
    }
}
