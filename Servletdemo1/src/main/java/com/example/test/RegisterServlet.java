package com.example.test;

import com.example.test.domain.User;
import com.example.test.serviceimpl.UserSeriveImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String usermail = req.getParameter("usermail");
        String pwd = req.getParameter("pwd");
        String pwd2 = req.getParameter("pwd");
        String sex=req.getParameter("sex");
        String telp = req.getParameter("tel");
        String intce = req.getParameter("intro");
        System.out.println(""+usermail+" "+username+" "+pwd+" "+sex+" "+telp +" "+intce);
        User user = new User();
        user.setUsername(username);
        user.setPwd(pwd);
       user.setUsermail(usermail);
        user.setGender(sex);
        user.setTel(telp);
        user.setIntro(intce);

        UserSeriveImpl userSerive = new UserSeriveImpl();
       int result= userSerive.register(user);
        if (result==0){
            resp.getWriter().write("此人已存在");
        }
        req.getRequestDispatcher("/index.jsp").forward(req,resp);

//        UserDaoImpl userDao = new UserDaoImpl();
//        userDao.queryByName(user.getUsername());


//        resp.getWriter().println("秦皇岛职业技术学院首页");
//        resp.setHeader("refresh","1");
//        resp.getWriter().println(new Date());

//        resp.getWriter().write(" "+telp+ " "+intce);
//        if (username.equals("cy")){
//            resp.sendRedirect("success.jsp");//重定向
//        }
//        else {
//            req.getRequestDispatcher("register.html").forward(req,resp);
//        }
  }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            this.doGet(req,resp);
    }
}
