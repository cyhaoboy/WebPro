package com.example.test.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "VisitorFilter",value = "/*",dispatcherTypes = DispatcherType.REQUEST)
public class VisitorFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
//        chain.doFilter(request, response);
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        // request.getContextPath()为站点根目录
        String contextPath = req.getRequestURI();//资源的定位符
        int flag = 0;
        //        System.out.println(contextPath);
        if (contextPath.contains("login.jsp") || contextPath.contains("register.html") || contextPath.contains("MyLoginServlet") || contextPath.contains("CodeServlet")||contextPath.contains("/bootstrap/")||contextPath.contains("/images/")||contextPath.contains("/ad/")||contextPath.contains("bookcover")) {
            //            System.out.println("login xiang guan");

            //放行
         chain.doFilter(req, resp);

        } else {
            //如果用户是已经登陆过的合法用户，那么flag=1
            HttpSession session = req.getSession();
            String username = (String) session.getAttribute("username");
            if (username != null) {
                flag = 1;
            }
           if (flag == 1) {
               System.out.println("not login");
               chain.doFilter(req, resp);
           }
            else {
                resp.sendRedirect("login.jsp");
            }
        }
        return;
    }
}
