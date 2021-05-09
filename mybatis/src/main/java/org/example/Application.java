package org.example;


import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;

import static org.springframework.boot.SpringApplication.run;

/**
 * 启动器 , 增加缓存支持
 * @author licc
 * @date 2021/05/08
 */
@EnableCaching
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = run(Application.class, args);
    }
}
