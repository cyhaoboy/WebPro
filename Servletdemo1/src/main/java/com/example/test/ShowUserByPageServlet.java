package com.example.test;

import com.example.test.domain.PageBean;
import com.example.test.domain.User;
import com.example.test.service.UserService;
import com.example.test.serviceimpl.UserSeriveImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ShowUserByPageServlet", value = "/ShowUserByPageServlet")
public class ShowUserByPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> condition = request.getParameterMap();
        UserSeriveImpl userSerive = new UserSeriveImpl();
        String  currentPage1 =request.getParameter("currentPage");
//        String chaxun=request.getParameter("chaxun");
        int currentPage;
        if (currentPage1!=null) {
            currentPage=Integer.valueOf(currentPage1);
        }else {
            currentPage=1;
        }
                
        String pageSize1=request.getParameter("pageSize");
        int pageSize;
        if (pageSize1!=null) {
            pageSize=Integer.valueOf(pageSize1);
        }else{
            pageSize=3;
        }
        PageBean<User> userPageBean= userSerive.page(currentPage,pageSize,condition);
//        int total = userSerive.totalCount();
//        int totalpage=userSerive.totalPage();
//        List<User> users=userSerive.queryByPage(currentPage,pageSize);
//        PageBean<User> userPageBean = new PageBean<>();
//        userPageBean.setTotalPage(totalpage);
//        userPageBean.setTotalCount(total);
//        userPageBean.setCurrentPage(0);
//        userPageBean.setList(users);
        request.setAttribute("pageBean",userPageBean);
        request.getRequestDispatcher("/showUserByPage.jsp").forward(request,response);
    }
}
