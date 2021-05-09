package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import java.io.Reader;

/**
 * @author licc
 * @date 2021/05/08
 */
public class MybatisApp {

    public static void main(String[] args) {
        String configFile = "mybatis-config.xml";
        Reader reader = null;

        try {
            //读取全局配置文件 组装为 Configuration 对象
            reader = Resources.getResourceAsReader(configFile);
            //获取 SqlSessionFactory 对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = build.openSession();
            sqlSession.selectOne("org.example.mapper.UserMapper.findById" , 1);
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
