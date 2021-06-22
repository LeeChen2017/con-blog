package org.example.dao;

import org.springframework.stereotype.Component;

/**
 * @author licc
 * @date 2021/6/20
 */
@Component
public class IndexDao implements Dao {

    /**
     * Spring Aop 支持支 使用SpringBean 的方法 执行连接点 ，所以将切点看出是 springBean上方法的执行。切点的声明分为两部分  ：名称 和
     * 任意方法的签名 ， 以及明确需要匹配的切点表达式，在常规 AOP，一个切点的由常规方法的定义来提供（根据方法定义来锁定 哪些方法作为切点） 并且切点
     * 表达式由@pointcut注解指定（方法作为切点签名 必须有void返回）
     */
    @Override
    public void query(){
        System.out.println("query from db---------------");
    }

}
