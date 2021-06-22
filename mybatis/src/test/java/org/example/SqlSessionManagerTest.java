package org.example;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionManager;
import org.junit.Test;

import java.io.Reader;
import java.util.List;

public class SqlSessionManagerTest {

    @Test
    public void testSqlSessionManager(){
        Reader reader = null;
        String configFile = "mybatis-config.xml";
        try {

            reader = Resources.getResourceAsReader(configFile);

            SqlSessionManager sqlSessionManager = SqlSessionManager.newInstance(reader);
            List<Object> objects = sqlSessionManager.selectList("org.example.mapper.UserMapper.findAll");
            System.out.println(objects);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
