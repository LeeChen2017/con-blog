package com.example.transaction;

import com.mysql.cj.x.protobuf.MysqlxPrepare;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.sql.*;

/**
 * TransactionManager demo
 *
 * @author licc
 * @date 2021/06/19
 *
 */
public class TransactionManagerDemo {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/xxl_job?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&serverTimezone=Asia/Shanghai";

    private static final String USER_NAME = "root";

    private static final String PASSWORD = "@#li12138";

    private static String insertSql = "insert into xxl_job_user values (4 , 'admin4' ,'12138' , 1 , null )";

    private static String updateSql = "update xxl_job_user set username = 'lisi' where id = 4";


    public static void main(String[] args) {

        final DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource(URL , USER_NAME , PASSWORD);
        try {


            DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(driverManagerDataSource);
            TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
            transactionTemplate.execute(new TransactionCallback() {
                @Override
                public Object doInTransaction(TransactionStatus status) {

                    Connection connection = DataSourceUtils.getConnection(driverManagerDataSource);


                    //status 持有的 connection  与 下列执行的connection 是同一个
                    Object savepoint = null;
                    try {
                        savepoint = status.createSavepoint();
                        PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
                        preparedStatement.executeUpdate();

                        PreparedStatement preparedStatement2 = connection.prepareStatement(updateSql);
                        preparedStatement2.executeUpdate();
                    } catch (TransactionException e) {

                        if (savepoint!= null) {
                            status.rollbackToSavepoint(savepoint);
                        } else {
                            status.isRollbackOnly();
                        }
                        e.printStackTrace();
                    } catch (Exception e2) {
                        if (savepoint == null) {
                            status.isRollbackOnly();
                        } else {
                            status.rollbackToSavepoint(savepoint);
                        }
                    }
                    return null;
                }
            });
        } catch (TransactionException e) {
            e.printStackTrace();
        }


    }


    private static Connection openConnection(){

        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    private static PreparedStatement preparedStatement(Connection connection, String sql, Boolean autoCommit){
        PreparedStatement preparedStatement = null;
        try {
            connection.setAutoCommit(autoCommit);
            preparedStatement = connection.prepareStatement(sql);
            return preparedStatement;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static void execute(PreparedStatement preparedStatement){
        try {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addUser(String insertSql){
        try {
            Connection connection = openConnection();
            PreparedStatement preparedStatement = preparedStatement(connection , insertSql , false);
            assert preparedStatement != null;
            execute(preparedStatement);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void updateUser (String updateSql){
        try {
            Connection connection = openConnection();
            PreparedStatement preparedStatement = preparedStatement(connection , updateSql , false);
            assert preparedStatement != null;
            execute(preparedStatement);
            int i = 1/0;
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
