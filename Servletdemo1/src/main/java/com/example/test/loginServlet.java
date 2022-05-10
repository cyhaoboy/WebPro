package com.example.test;

import com.example.test.domain.User;
import com.example.test.serviceimpl.UserSeriveImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@WebServlet( "/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");

        String chkcode = req.getParameter("code");
        HttpSession session = req.getSession();
        String chkcode1 = (String) session.getAttribute("chkcode");
        if (!chkcode.equalsIgnoreCase(chkcode1)) {
            resp.sendRedirect("login.html");
            System.out.println(chkcode);
        } else {
//        System.out.println(""+username +" "+pwd);
//
            String username = req.getParameter("username");
            String pwd = req.getParameter("pwd");
            User user = new User();
            user.setUsername(username);
            user.setPwd(pwd);

            UserSeriveImpl userSerive = new UserSeriveImpl();
            boolean result = userSerive.login(user);
            if (result) {
              String remember = req.getParameter("remember");
               if ("1".equals(remember)) {
                    Cookie cookie = new Cookie("username",username);
                    Cookie password = new Cookie("pwd", pwd);
                    cookie.setMaxAge(60*60*24*10);
                    password.setMaxAge(60*60*24*10);
                    resp.addCookie(cookie);
                    resp.addCookie(password);
               }
                resp.sendRedirect("index.html");
            }else{
                resp.sendRedirect("login.jsp");

            }
//        if (username.equals("cy")&&pwd.equals("123")){
//            resp.sendRedirect("success.jsp");
//        }
//        else {
//            req.getRequestDispatcher("login.html").forward(req,resp);
//        }
        }

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
