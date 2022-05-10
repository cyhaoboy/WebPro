package com.example.test.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/aa")//对哪个应用实行过滤操作
public class FilterDemo implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("filter init 被调用");
    }

    public void destroy() {
        System.out.println("FilterDemo 被销毁");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("过滤器 doFiliter");
        chain.doFilter(req, resp);//放行
//        System.out.println("filter go back");

    }
}
