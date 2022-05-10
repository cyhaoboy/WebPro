package com.example.test;

import com.example.test.domain.User;
import com.example.test.service.UserService;
import com.example.test.serviceimpl.UserSeriveImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteUserServlet", value = "/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        this.doPost(request,response);
        String id0 = request.getParameter("id");
       int id = Integer.parseInt(id0);
        User user = new User();
        UserSeriveImpl userSerive = new UserSeriveImpl();
        user.setId(id);
        userSerive.deleteUser(user);
        request.getRequestDispatcher("/showUserByPage.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String[] values = request.getParameterValues("sel");
        User user = new User();
        UserSeriveImpl userSerive = new UserSeriveImpl();
        for (String str:values){
            int id=Integer.parseInt(str);
             user.setId(id);
            userSerive.deleteUser(user);
        }
        request.getRequestDispatcher("/showUserByPage.jsp").forward(request,response);

//        String id0=request.getParameter("id");
//        int id =Integer.valueOf(id0);
//        User user = new User();
//        user.setId(id);
//        UserSeriveImpl userSerive = new UserSeriveImpl();
//        int i=userSerive.deleteUser(user);
//        if (i==1){
//            request.getRequestDispatcher("/showUserByPage.jsp").forward(request,response);
//        }
    }
}
