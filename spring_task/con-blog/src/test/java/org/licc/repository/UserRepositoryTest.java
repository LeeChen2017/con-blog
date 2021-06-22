package org.licc.repository;

import org.junit.Before;
import org.junit.Test;
import org.licc.config.PlatformConfig;
import org.licc.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author licc
 * @date 2021/6/22
 */
public class UserRepositoryTest {

    AnnotationConfigApplicationContext annotationConfigApplicationContext = null;

    @Before
    public void before(){
        annotationConfigApplicationContext = new AnnotationConfigApplicationContext(PlatformConfig.class);


    }

    @Test
    public void test1(){
        UserRepository bean = annotationConfigApplicationContext.getBean(UserRepository.class);
        User user = new User();

        user.setName("zhangsan");
        user.setPassword("123");
        user.setTel("17788719092");

        User save = bean.save(user);
    }

}
