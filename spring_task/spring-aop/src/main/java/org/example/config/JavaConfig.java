package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author licc
 * @date 2021/6/20
 */
@Configuration
/**
 * Enable AspectJAutoProxy 代理模式默认 为JDB代理  JDK代理 为接口代理 CGLIB代理 为类代理
 */
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"org.example"})
public class JavaConfig {

}
