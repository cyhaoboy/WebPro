package com.example.test;

import com.example.test.daoimpl.UserDaoImpl;
import com.example.test.domain.User;
import com.example.test.serviceimpl.UserSeriveImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SaveServlet", value = "/SaveServlet")
public class SaveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String users=request.getParameter("username");
        String pwd=request.getParameter("pwd");
        String id0=request.getParameter("id");
        int id=Integer.valueOf(id0);
        User user = new User();
        user.setUsername(users);
        user.setPwd(pwd);
        user.setId(id);
        UserDaoImpl userDao = new UserDaoImpl();
        int i=userDao.updateUser(user);
        if (i==1){

            request.getRequestDispatcher("/showUserByPage.jsp").forward(request,response);
        }
    }
}
