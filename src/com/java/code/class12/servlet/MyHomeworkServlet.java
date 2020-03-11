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


@WebServlet("/myhomework")
public class MyHomeworkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        String my_id=req.getParameter("my_id");

        List<StudentHomework> list = StudentHomeworkJdbc.selectmy(my_id);

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
