package com.example.transaction;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author licc
 * @date 2021/06/17
 *
 */
public class SpringTransactionDemo {
    static Object lock = new Object();

    private final static String url = "jdbc:mysql://127.0.0.1:3306/xxl_job?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&serverTimezone=Asia/Shanghai";
    private final static String user = "root";
    private final static String password = "@#li12138";
    private static Connection getConnection(boolean autoCommit){
        Connection connection1 = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection1 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/xxl_job?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&serverTimezone=Asia/Shanghai" , "root" , "@#li12138");
            connection1.setAutoCommit(autoCommit);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection1;
    }

    public static void main(String[] args) {

        final DataSource ds = new DriverManagerDataSource(url , user , password);

        final TransactionTemplate transactionTemplate = new TransactionTemplate();

        final String insertSql = "insert into xxl_job_user values (4 , 'admin4' ,'12138' , 1 , null )";

        transactionTemplate.setTransactionManager(new DataSourceTransactionManager(ds));

        transactionTemplate.execute(new TransactionCallback<Object>() {

            @Override
            public Object doInTransaction(TransactionStatus status) {

                Connection connection = DataSourceUtils.getConnection(ds);
                
                //插入一条数据
                Object savepoint = null;
                try {

                    savepoint = status.createSavepoint();
                    PreparedStatement preparedStatement = connection.prepareStatement(insertSql);

                    preparedStatement.executeUpdate();
                    //设置 回滚点

                    //更新数据
                    String  updateSql = "update xxl_job_user set username = 'lisi' where id = 4";
                    PreparedStatement preparedStatement2 = connection.prepareStatement(updateSql);

                    preparedStatement2.executeUpdate();

                   // int i = 1/0;

                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("插入失败");
                } catch (Exception e1) {
                    e1.printStackTrace();
                    System.out.println("更新失败");
                    if (savepoint!=null) {
                        status.rollbackToSavepoint(savepoint);
                    }
                    status.isRollbackOnly();
                }


                return null;
            }
        });



    }




}
