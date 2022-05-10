package com.example.test.JDBC;


import com.example.test.JDBCUtils.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.*;

public class TestCon {
     private   JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
        public static void main(String[] args) throws SQLException {

            Connection connection =JDBCUtils.getConn() ;
//            String sql = "select * from user ";
            String sql="delete from user where id=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("username");
                String pwd = resultSet.getString("pwd");
                System.out.println(id+" "+name+" "+pwd);
            }
            JDBCUtils.closeCon();
        }


//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bookstore?user=root&password=783186");
//        String sql="insert into user (username,pwd) values(?,?)";
//        PreparedStatement pst = conn.prepareStatement(sql);
//        pst.setString(1, "cy");
//        pst.setString(2,"12345678");
//
//        pst.execute();
    @Test
    public void updateTest(){

        String sql ="update user set pwd=? where username=?";

        jdbcTemplate.update(sql,"00000","admin");
    }
    @Test
    public  void addTest(){
        String sql="insert into user(username,pwd) values(?,?)";
        jdbcTemplate.update(sql,"常远","666");
    }
    @Test
    public void deleteTest(){
        String sql="delete from user where username=?";
        jdbcTemplate.update(sql,"cy");
    }
    }

