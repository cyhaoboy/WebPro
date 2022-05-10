package com.example.test.dao;

import com.example.test.domain.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    public int addUser(User user);
    public int deleteUser(User user);
    public int updateUser(User user);
    public List<User> queryAllUser();
    public boolean queryByName(String name);
    public User queryById(int id);
    public boolean queryByNameandPassword(String name,String password);
//    public List<User> queryByPage(int n,int count);

    public int queryByPageTotalCount(Map<String,String[]> condition);
    public List<User> queryByPage(int n, int count, Map<String,String[]> condition);
}
