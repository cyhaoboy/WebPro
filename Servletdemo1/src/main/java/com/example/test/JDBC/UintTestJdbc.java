package com.example.test.JDBC;

import com.example.test.JDBCUtils.JDBCUtils;
import com.example.test.domain.User;

import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class UintTestJdbc {

     private   JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Test
    public void testUpdate(){
       String sql="update user set username=? pwd=? where id=?";
        jdbcTemplate.update(sql,"admin","123456",1);
    }
    @Test
    public  void addTest(){
        String sql="insert into user(username,pwd) values(?,?)";
        jdbcTemplate.update(sql,"周迅","654214");
    }
    @Test
    public void deleteTest(){
        String sql="delete from user where username=?";
        jdbcTemplate.update(sql,"cy");
    }
    @Test
    public void findByName(){
        String sql="select * from user where user=? and pwd=?";

        Map<String,Object>map=jdbcTemplate.queryForMap(sql,"cy","666");

        if (map.isEmpty()){
            System.out.println("查无此人");
        }
        else {

            System.out.println("欢迎访问我的网站");
        }
        Set<String>keys=map.keySet();
        for (String key:keys){

        }
    }
    @Test
    public void findAll(){
        String sql="select * from user";
        List<Map<String,Object>>maps=jdbcTemplate.queryForList(sql);
        for (Map map:maps){
            System.out.println(map);
        }
    }
    @Test
    public void findAllList(){

        String sql="select * from user";
        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
        System.out.println(list);

    }
    @Test
    public void queryTotal(){
        String sql ="select count(*) from user";
        Integer integer = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(integer);

    }
    @Test
    public void findByname(){
        String sql="select * from user where username=?";
        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class),"常远");
        if (list.size()!=0){
            System.out.println("找到此人");
        }else {
            System.out.println("查无此人");
        }

    }


}
