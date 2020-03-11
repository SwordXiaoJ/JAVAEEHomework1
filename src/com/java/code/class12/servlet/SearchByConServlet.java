package com.java.code.class12.servlet;

import com.java.code.class12.jdbc.StudentHomeworkJdbc;
import com.java.code.class12.model.StudentHomework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/search")
public class SearchByConServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<StudentHomework> list=null;

        String seastu_id=req.getParameter("seastu_id");
        String seahome_id=req.getParameter("seahome_id");

        if(seastu_id=="")
        {
            System.out.println(seahome_id);
            list = StudentHomeworkJdbc.selectbyhome(seahome_id);
        }else if(seahome_id=="")
        {
            list = StudentHomeworkJdbc.selectbystu(seastu_id);
        }
        else
        {
            list = StudentHomeworkJdbc.selectbycross(seastu_id,seahome_id);
        }






        req.setAttribute("list", list);//在请求里面放了一个list,里面的值是list

        if(null == list || list.size() <= 0)
        {
            req.setAttribute("error", "没有查询到指定数据");//在请求里面放了一个list,里面的值是list
        }
        else
        {
            req.setAttribute("error", "");//在请求里面放了一个list,里面的值是list
        }


        req.getRequestDispatcher("JSP/ShowAllHome.jsp").forward(req, resp);//将请求分发到index.jsp,重定向到index.jsp
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }
}