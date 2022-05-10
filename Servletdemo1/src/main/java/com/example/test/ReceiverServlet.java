package com.example.test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/ReceiverServlet")
public class ReceiverServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        Cookie[] cookies=req.getCookies();
        System.out.println("ReceiverServlet获得的Cookie如下：");
        for (Cookie cookie:cookies)
        {
            String name=cookie.getName();
            String value=cookie.getValue();
            System.out.println(name+" "+value);
        }





    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}