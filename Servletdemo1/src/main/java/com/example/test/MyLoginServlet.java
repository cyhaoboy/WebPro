package com.example.test;

import com.example.test.domain.User;
import com.example.test.JDBCUtils.JDBCUtils;
import com.example.test.service.UserService;
import com.example.test.serviceimpl.UserSeriveImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/MyLoginServlet")
public class MyLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");//防止乱码
        response.setContentType("text/html;charset=UTF-8");
//        String msg=request.getParameter("msg");
//        System.out.println(msg);

        String chkcode=request.getParameter("code");//用户输入的验证码
        HttpSession session=request.getSession();
        String chkcode1=(String) session.getAttribute("chkcode");//图片中的验证码

        if (!chkcode.equalsIgnoreCase(chkcode1))
        {
            response.getWriter().write("<script type='text/javascript'>alert('验证码错误');</script>");
//            response.getWriter().write("<javascript>alert('验证码错误');</javascript>");
            response.setHeader("refresh","1;url=login.jsp");
//            response.sendRedirect("mylogin.jsp");
        }
        else {

            String user = request.getParameter("username");
            String password = request.getParameter("pwd");
            User user1 = new User();
            user1.setUsername(user);
            user1.setPwd(password);
            UserService userService = new UserSeriveImpl();
            boolean login = userService.login(user1);
            String remeber = request.getParameter("remeber");
            System.out.println("login and rember="+login+"  "+remeber);

            if (login == true) {

                System.out.println(remeber);
                if (remeber!=null){//用户勾选了十天免登录功能，做如下操作：
                    //保存用户名、密码
                    //1、创建cookie
                    Cookie cookie = new Cookie("loginuser",user+"-"+password);
//                    Cookie username=new Cookie("username",user);
//                    Cookie pwd=new Cookie("pwd",password);
                    //2、设置cookie存活10天，单位为秒
                    cookie.setMaxAge(10*24*60*60);
//                    username.setMaxAge(10*24*60*60);
//                    pwd.setMaxAge(10*24*60*60);
                    //3、保存cookie
                    response.addCookie(cookie);
//                    response.addCookie(username);
//                    response.addCookie(pwd);
                    System.out.println("cookie保存完毕");
                }
                session.setAttribute("username",user);
//                System.out.println("当前登录的用户是："+user);
//                response.sendRedirect("index.jsp");
                request.getRequestDispatcher("/index.jsp").forward(request,response);
            } else {
//                response.sendRedirect("login.jsp");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
//        String sql="select * from stu where user=? and pwd=? ";
//        PreparedStatement pst=null;
//        try {
//            pst=conn.prepareStatement(sql);
//            pst.setString(1,user);
//            pst.setString(2,password);
//            ResultSet resultSet=pst.executeQuery();
//            if(resultSet.next())
//            {
//                response.sendRedirect("shouye.html");
//            }
//            else
//            {
//                response.sendRedirect("mylogin.html");
//            }
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//
//
//        String chkcode = request.getParameter("chkcode");
//       HttpSession session= request.getSession();
//       String chkcode1=(String) session.getAttribute("chkcode");
//
//        System.out.println(chkcode+":"+chkcode1);
////        System.out.println("MyLoginServlet:" + user + " " + password + " " + chkcode);
////        System.out.println(chkcode);
////        request.getRequestDispatcher("TestServlet").forward(request,response);
//        response.sendRedirect("TestServlet");//重定向是两次请求（第二次为空）

//        if (user.equals("wzw")&& password.equals("123")) {
//            response.sendRedirect("http://www.baidu.com");
////            response.sendRedirect("shouye.html");//重定向，不是一次请求
//        } else {
//            response.getWriter().write("<script>alert('用户名或密码错误');</script>");
//            response.sendRedirect("mylogin.html");
//        }
        }
    }
}
