package com.example.test.serviceimpl;

import com.example.test.dao.UserDao;
import com.example.test.daoimpl.UserDaoImpl;
import com.example.test.domain.PageBean;
import com.example.test.domain.User;
import com.example.test.service.UserService;

import java.util.List;
import java.util.Map;

public class UserSeriveImpl implements UserService {
   private UserDaoImpl userDao = new UserDaoImpl();
    @Override
    public int register(User user) {

        if (userDao.queryByName(user.getUsername())){

            return 0;
        }else {
            userDao.addUser(user);
            return 1;
        }

    }


    @Override
    public boolean login(User user) {
        return userDao.queryByNameandPassword(user.getUsername(),user.getPwd());
    }

    @Override
    public boolean queryByName(String name) {
        return  userDao.queryByName(name);
    }

    @Override
    public List<User> getAll() {
         List<User> users=userDao.queryAllUser();
        return users;
    }


//    @Override
//    public List<User> queryByPage(int n, int count) {
//        List<User> users = userDao.queryByPage(n, count);
//        return users;
//    }

    public  int totalCount(Map<String,String[]> condition){
        int total = userDao.queryByPageTotalCount(condition);
        return total;

    }

    @Override
    public User queryById(int id) {
        User user = userDao.queryById(id);
        return user;
    }

    @Override
    public int deleteUser(User user) {
        int i=userDao.deleteUser(user);
        return i;
    }

    @Override
    public int addUser(User user) {
        int i=userDao.updateUser(user);

        
        return i;
    }
//    public int totalPage(){
//
//        return totalpage;
//
//    }

    public PageBean<User> page(int n, int count, Map<String,String[]> condition) {
        PageBean<User> pageBean =new PageBean<>();
        List<User> users= userDao.queryByPage(n,count,condition);
        pageBean.setList(users);
        pageBean.setTotalCount(userDao.queryByPageTotalCount(condition));
        int totalpage=totalCount(condition)%count==0?totalCount(condition)/count:totalCount(condition)/count+1;

        pageBean.setTotalPage(totalpage);
        if (n<totalpage){
            pageBean.setCurrentPage(n);
        }else {
            pageBean.setCurrentPage(1);
        }
        return pageBean;

    }
}
