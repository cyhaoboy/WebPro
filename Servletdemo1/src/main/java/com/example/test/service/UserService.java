package com.example.test.service;

import com.example.test.domain.PageBean;
import com.example.test.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    public int register(User user);

    public boolean login(User user);

    public boolean queryByName(String name);

    public List<User> getAll();

//    public List<User> queryByPage(int n,int count);

    public int totalCount(Map<String,String[]> condition);

    public PageBean<User> page(int n, int count, Map<String,String[]> condition);
//    public int totalPage();
    public User queryById(int id);
    public  int deleteUser(User user);

    public int addUser(User user);

}
