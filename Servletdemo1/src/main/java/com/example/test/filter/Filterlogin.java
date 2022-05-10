package com.example.test.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "Filterlogin" ,value = ("/login.jsp"))
public class Filterlogin implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        Cookie[] cookies =req.getCookies() ;
        int flag=0;
        if (cookies!=null){
            for (Cookie cookie:cookies){
                String loginusername=cookie.getName();
                if (loginusername.equals("loginuser")){
                    HttpSession session = req.getSession();
                String value=cookie.getValue();
                String[] split=value.split("-");
                session.setAttribute("username",split[0]);
                    flag=1;
                    break;
                }
            }

        }
        System.out.println("flag="+flag);
        if (flag==1){
            req.getRequestDispatcher("/index.jsp").forward(request,response);
        }else{
            chain.doFilter(request, response);
        }

    }
}
