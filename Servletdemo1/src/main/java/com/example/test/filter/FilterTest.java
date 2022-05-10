package com.example.test.filter;


import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "FilterTest")
public class FilterTest implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("testFilter");
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String requestURI = req.getRequestURI();
        System.out.println("FilterTest  called");
        int flag = 0, k = 0;
        if (requestURI.contains("login.jsp") || requestURI.contains("CodeS")||requestURI.contains("MyLoginServlet")||requestURI.contains("/bootstrap")||requestURI.contains("/img")) {
            flag = 1;
            System.out.println("flag=1");
        }
        HttpSession session = req.getSession();
        Object username = session.getAttribute("username");
        if (username != null) k = 1;
        if (flag == 1) {
            chain.doFilter(request, response);
            System.out.println("login.jsp 放行");
        } else {
            if (k == 1) {
                chain.doFilter(request, response);
                System.out.println("有session放行");
            } else {
                resp.sendRedirect("login.jsp");
            }
        }
        System.out.println("do filter");
    }
}
