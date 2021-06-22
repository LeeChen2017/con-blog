package org.example.dao;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.example.proxy.TestInvocation;
import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * @author licc
 * @date 2021/6/21
 */
public class TestProxy {

    @Test
    public void test1(){
        Dao dao = (Dao) Proxy.newProxyInstance(TestProxy.class.getClassLoader() , new Class[]{Dao.class} , new TestInvocation(new IndexDao()));
        dao.query();
    }

}
