package com.example.test;

import com.example.test.domain.User;
import com.example.test.serviceimpl.UserSeriveImpl;
import org.apache.commons.beanutils.BeanUtils;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "AddUserServlet", value = "/AddUserServlet")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        UserSeriveImpl userSerive = new UserSeriveImpl();
        userSerive.register(user);
        request.getRequestDispatcher("/showUserByPage.jsp").forward(request,response);
//        String username=request.getParameter("username");
//        String pwd = request.getParameter("pwd");
//        String usermail = request.getParameter("usermail");
//        String gender = request.getParameter("sex");
//        String tel = request.getParameter("tel");
//        String intro = request.getParameter("intro");
//        User user = new User();
//        user.setUsername(username);
//        user.setPwd(pwd);
//        user.setUsermail(usermail);
//        user.setGender(gender);
//        user.setTel(tel);
//        user.setIntro(intro);
//        UserSeriveImpl userSerive = new UserSeriveImpl();
//        userSerive.addUser(user);

    }
}
