package org.example.proxy;

import org.example.dao.Dao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author licc
 * @date 2021/6/21
 */
public class TestInvocation implements InvocationHandler {


    private Dao dao;

    public TestInvocation(Dao dao) {
        this.dao = dao;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy");
        dao.query();
        return proxy;
    }
}
