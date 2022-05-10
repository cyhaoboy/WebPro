package com.example.test;

import com.example.test.domain.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AjaxDemoServlet", value = "/AjaxDemoServlet")
public class AjaxDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            User user = new User();
            user.setId(11);
            user.setUsername("zhangsan");
            user.setPwd("123456");
            user.setUsermail("c154@163.com");
            user.setGender("男");
            user.setTel("1284516455");
            user.setIntro("nihao");
            ObjectMapper Mapper = new ObjectMapper();
            String s=Mapper.writeValueAsString(user);

    }
}
