package com.example.test;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/LastAccessServlet")
public class LastAccessServlet extends HttpServlet {
    //    private String message;
//
//    public void init() {
//        message = "Hello World!";
//    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        String lastAccessTime=null;
        Cookie[] cookies=req.getCookies();
        Cookie ck2=null;
        for (Cookie ck:cookies)
        {
            if ("lastAccessTime".equals(ck.getName()))
            {
                String value=ck.getValue();
                String decode= URLDecoder.decode(value,"utf-8");//对cookie值解码
                resp.getWriter().write("你上次的访问时间是："+decode);
                lastAccessTime=ck.getValue();
                ck2=ck;//获取已经保存上次访问时间的cookie
                break;
            }
        }
        if (lastAccessTime==null){
            resp.getWriter().write("你是首次访问本站");
        }
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String currentTime=simpleDateFormat.format(date);
        String encode= URLEncoder.encode(currentTime,"utf-8");

        Cookie cookie=new Cookie("lastAccessTime",encode);
        System.out.println(currentTime);
        resp.addCookie(cookie);
    }
    public void destroy(){

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
