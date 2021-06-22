package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.example.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Reader;

/**
 * @author licc
 * @date 2021/05/08
 */
public class MybatisApp {

    private static final Logger logger = LoggerFactory.getLogger(MybatisApp.class);

    public static void main(String[] args) {
        String configFile = "mybatis-config.xml";
        Reader reader = null;

        try {
            //读取全局配置文件 组装为 Configuration 对象
            reader = Resources.getResourceAsReader(configFile);
            //获取 SqlSessionFactory 对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = build.openSession();
            User user = (User)sqlSession.selectOne("org.example.mapper.UserMapper.findById", 1);
            logger.debug("current user message :{}" , user.toString());


            sqlSession.clearCache();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
