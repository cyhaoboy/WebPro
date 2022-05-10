package com.example.test;

import com.example.test.domain.User;
import com.example.test.serviceimpl.UserSeriveImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "QueryAllUserServlet", value = "/QueryAllUserServlet")
public class QueryAllUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        UserSeriveImpl userSerive = new UserSeriveImpl();
        List<User> users = userSerive.getAll();
        request.setAttribute("users",users);
        System.out.println(users);
        request.getRequestDispatcher("/showAllUser.jsp").forward(request,response);
    }
}
