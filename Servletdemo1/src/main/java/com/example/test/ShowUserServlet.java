package com.example.test;

import com.example.test.domain.User;
import com.example.test.serviceimpl.UserSeriveImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ShowUserServlet", value = "/ShowUserServlet")
public class ShowUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id =Integer.parseInt(request.getParameter("id"));
        UserSeriveImpl userSerive = new UserSeriveImpl();
        User user = userSerive.queryById(id);
        request.setAttribute("user",user);
        request.getRequestDispatcher("/showUser.jsp").forward(request,response);
    }
}
