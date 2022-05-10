package com.example.test.daoimpl;

import com.example.test.JDBCUtils.JDBCUtils;
import com.example.test.dao.UserDao;
import com.example.test.domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.*;

public class UserDaoImpl implements UserDao {
     private JdbcTemplate jdbcTemplate=  new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public int addUser(User user) {
        String sql="insert into user(username,pwd,usermail,gender,tel,intro) values(?,?,?,?,?,?)";
       int update= jdbcTemplate.update(sql,user.getUsername(),user.getPwd(),user.getUsermail(),user.getGender(),user.getTel(),user.getIntro());
        return update;
    }

    @Override
    public int deleteUser(User user) {
        String sql="delete from user where id=?";
        int update= jdbcTemplate.update(sql,user.getId());
        return update;
    }

    @Override
    public int updateUser(User user) {
        String sql="update user set username=? , pwd=? where id=?";
        int update=jdbcTemplate.update(sql,user.getUsername(),user.getPwd(),user.getId());
        return update;
    }

    @Override
    public List<User> queryAllUser() {
        String sql="select * from user";
        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return list;
    }
//    @Test
//    public void mytest()
//    {
//        List<User> users = queryAllUser();
//        System.out.println(users);
//    }

    @Override
    public boolean queryByName(String name) {
        String sql="select * from user where username=?";
        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class),name);
        if (list.size()!=0){
            return true;
        }else {
            return false;
        }


    }

    @Override
    public User queryById(int id) {
        String sql="select * from user where id=?";
        User user = jdbcTemplate.queryForObject(sql,  new BeanPropertyRowMapper<User>(User.class), id);
        return user;
    }

    @Override
    public boolean queryByNameandPassword(String name, String password) {
        String sql="select * from user where username=? and pwd=?";
        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class),name,password);
        if (list.size()!=0){
            return true;
        }else {
            return false;
        }

    }
    public void convert(Map<String,String[]>map,StringBuilder sb,List<Object> paras){
        String condition=  " where 1=1 ";
         sb.append(condition);
        Set<String> keyset=map.keySet();
        Iterator<String> iterator = keyset.iterator();
        String value=null;

        while (iterator.hasNext()){
            String key=iterator.next();
            if (!key.equals("currentPage")&&!key.equals("pageSize")){
                value=map.get(key)[0];
                if (value!=null){
                    String tj=" and "+key+" like ? ";
                    sb.append(tj);
                    value=value+ "%";
                    paras.add(value);
                }
            }
        }
    }
    @Override
    public List<User> queryByPage(int n, int count, Map<String,String[]> map) {
        StringBuilder sb = new StringBuilder();
        List<Object> paras = new ArrayList<Object>();
           convert(map,sb,paras);
        sb.insert(0,"select * from user");
        sb.append("limit ?,?");
        String sql =sb.toString();
        sb.toString();
        int start=(n-1)*count;
        int total=queryByPageTotalCount(map);
        if (start>total){
            start=0;
        }
        paras.add(start);
        paras.add(count);
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class), paras.toArray());
        return users;

    }

    public int queryByPageTotalCount(Map<String,String[]> map){
        StringBuilder sb = new StringBuilder();
        List<Object> paras = new ArrayList<Object>();
        convert(map,sb,paras);
        sb.insert(0,"select count(*) from user");
        String sql=sb.toString();
//            String sql="select count(*) from user";
        Integer total= jdbcTemplate.queryForObject(sql,Integer.class,paras.toArray());
          return total;
    }

//   @Test
//    public void myTest(){
//       int users=queryByPageTotalCount();
//       System.out.println(users);
//
//   }
}
