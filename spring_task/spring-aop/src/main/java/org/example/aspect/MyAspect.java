package org.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 *
 * 自定义切面 需要增加 @AspectJ 与Component 已便与IOC 支持
 * 切面本身不可以作为其他切面的目标，类上的@Aspect表明它是一个切面并且被排除在自动代理的范围之外
 *
 *
 * @author licc
 * @date 2021/6/20
 */
@Aspect
@Component
public class MyAspect {

    /**
     * 切面中的切点 返回值必须为 void
     * execution 最小粒度为方法
     */
    @Pointcut(value = "execution(* query(..))")
    public void anyQuery(){

    }

    @Pointcut("within(org.example.dao.IndexDao)")
    public void pointCutWithin(){

    }

    @After(value = ("anyQuery()"))
    public void after(JoinPoint joinPoint){

        Object[] args = joinPoint.getArgs();


        System.out.println("after execution ------");
    }



    /**
     * within 最小粒度为 类
     */
    @After(("pointCutWithin()"))
    public void afterWithin(){
        System.out.println("within point cut");
    }


}
