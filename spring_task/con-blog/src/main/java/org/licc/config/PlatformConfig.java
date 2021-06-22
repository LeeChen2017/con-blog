package org.licc.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.licc.domain.User;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.relational.core.mapping.event.BeforeSaveCallback;
import org.springframework.data.relational.core.mapping.event.RelationalEvent;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 *
 * 持久层配置 数据库连接池
 * 事务配置
 * 全局日志
 *
 * @author licc
 * @date 2021/6/22
 */
@Configuration
@EnableJdbcRepositories(basePackages = "org.licc.repository")
public class PlatformConfig extends AbstractJdbcConfiguration {

    private String url;

    private String username;

    private String password;

    private Integer maxIdle;

    @Bean
    public DataSource dataSource(){
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

        try {
            comboPooledDataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
            comboPooledDataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/xxl_job?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&serverTimezone=Asia/Shanghai");
            comboPooledDataSource.setUser("root");
            comboPooledDataSource.setPassword("@#li12138");

            comboPooledDataSource.setMaxPoolSize(200);
            comboPooledDataSource.setMaxIdleTime(500);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return comboPooledDataSource;

    }

    @Bean("transactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager(){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource());

        return dataSourceTransactionManager;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(JdbcOperations operations) {
        return new NamedParameterJdbcTemplate(operations);
    }


    @Bean
    public BeforeSaveCallback<User> userBeforeSaveCallback(){
        return (entity , jdbcAggregateTemplate) ->{
            entity.saveCreateTime();
            return entity;
        };


    }

    @Bean
    public ApplicationListener<?> loggingListener() {

        return (ApplicationListener<ApplicationEvent>) event -> {
            if (event instanceof RelationalEvent) {
                System.out.println("Received an event: " + event);
            }
        };
    }


}