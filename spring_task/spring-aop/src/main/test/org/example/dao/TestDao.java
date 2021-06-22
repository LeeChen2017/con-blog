package org.example.dao;

import org.example.config.JavaConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author licc
 * @date 2021/6/20
 */
public class TestDao {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);
        Dao bean = annotationConfigApplicationContext.getBean(Dao.class);
        bean.query();
    }
}
