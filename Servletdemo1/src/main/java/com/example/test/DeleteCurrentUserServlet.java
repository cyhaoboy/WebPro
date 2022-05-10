package com.example.test;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/DeleteCurrentUserServlet")
public class DeleteCurrentUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie ck : cookies) {
                if ("username".equals(ck.getName())) {
                    ck.setMaxAge(0);
                    response.addCookie(ck);//这两句话才能删除名字是username的cookie
                    break;
                }
            }
            response.sendRedirect("login.jsp");
        }
    }
}
