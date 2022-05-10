package com.example.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet( "/ServletDemo1")
public class ServletDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, UnsupportedEncodingException {
     doPost(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");

        String user = request.getParameter("user");
        String pwb = request.getParameter("pwb");
        System.out.println("user:" + user + "pwb:" + pwb);

        System.out.println("请求的参数名有：");
        Enumeration<String> parameterNames = request.getParameterNames();

            while(parameterNames.hasMoreElements()){
                System.out.println(parameterNames.nextElement()+";");
        }

        System.out.println("");
        System.out.println("map参数集合如下：");
        Map<String, String[]> parameterMap = request.getParameterMap();

        Set<String> names = parameterMap.keySet();
        for (String str : names){
            System.out.println(str+":   ");
            String[] hobbys = parameterMap.get(str);
            for (String myhobby : hobbys){
                System.out.println(myhobby+"       ");
            }
        }
//        Enumeration<String> headerName = request.getHeaderNames();
//        while (headerName.hasMoreElements()){
//
//            String s= headerName.nextElement();
//            if (s.equals("referer")){
//                String header = request.getHeader(s);
//                System.out.println("此请求来源于："+header);
//            }
//        }


    }
}
