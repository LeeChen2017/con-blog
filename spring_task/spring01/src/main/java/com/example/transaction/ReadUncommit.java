package com.example.transaction;

import java.math.BigDecimal;
import java.sql.*;

/**
 * @author licc
 * @date 2021/06/17
 *
 */
public class ReadUncommit {

    public static void main(String[] args) throws Exception {

        Connection connection = getConnection(true);
        String sql = "select * from xxl_job_user t where t.id = 1";

        final String insertSql = "insert into xxl_job_user values (2 , 'admin2' ,'12138' , 1 , null )";

        String deleteSql = "delete from xxl_job_user where id = 2";


        //先插入 再读取
        //insertAutoCommit(deleteSql);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                insertAutoCommit(insertSql);
            }
        });

        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });




//        PreparedStatement preparedStatement = getPreparedStatement(connection, sql);
//
//        ResultSet resultSet = getResultSet(preparedStatement);
//
//        assert resultSet != null;
//        while (resultSet.next()) {
//            BigDecimal bigDecimal = resultSet.getBigDecimal(1);
//            System.out.println(bigDecimal);
//        }
//        preparedStatement.close();
//        connection.close();
    }

    private static void insertAutoCommit(String sql){
        Connection connection = getConnection(true);
        PreparedStatement preparedStatement = getPreparedStatement(connection , sql);
        try {
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 不允许自动提交
     */
    private static void insertNoAutoCommit(String insertSql){
        Connection connection = getConnection(false);
        PreparedStatement preparedStatement = getPreparedStatement(connection , insertSql);
        try {
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询数据
     * @param selectSql sql语句
     */
    private static void select(String selectSql){
        try {
            Connection connection = getConnection(true);
            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            PreparedStatement preparedStatement = getPreparedStatement(connection , selectSql);
            ResultSet resultSet = preparedStatement.executeQuery();
            String result = resultSet.next()?resultSet.toString():"3";
            System.out.println(result);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取结果集
     * @param preparedStatement preparedStatement
     * @return ResultSet
     */
    private static ResultSet getResultSet(PreparedStatement preparedStatement){
        try {
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 获取预处理对象
     * @param connection connection
     * @param sql sql语句
     * @return 与处理对象
     */
    private static PreparedStatement getPreparedStatement( Connection connection , String sql ){
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return preparedStatement;
    }


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
//        finally {
//            try {
//                assert connection1 != null;
//                connection1.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
        return connection1;
    }




}
