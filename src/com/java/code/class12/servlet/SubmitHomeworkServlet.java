package com.java.code.class12.servlet;

import com.java.code.class12.jdbc.StudentHomeworkJdbc;
import com.java.code.class12.model.StudentHomework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@WebServlet("/submithomework")
public class SubmitHomeworkServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        /**
         * 赋值
         */
        Date create_t = null;

        List<StudentHomework> temp = StudentHomeworkJdbc.selectAll();
        int allid=temp.size();
        allid+=1;

        String allidstr=String.valueOf(allid);

        Long id =Long.parseLong(allidstr);

        String s_id_str=req.getParameter("s_id");
        Long s_id=Long.parseLong(s_id_str);
        String h_id_str=req.getParameter("h_id");
        Long h_id=Long.parseLong(h_id_str);


        String h_titile=req.getParameter("h_title");
        String h_content=req.getParameter("h_content");

        Timestamp dateNow=new Timestamp(System.currentTimeMillis());

        StudentHomework SubNewHomework=new StudentHomework(id,s_id,h_id,h_titile,h_content,dateNow,dateNow);




        StudentHomeworkJdbc.addStudentHomework(SubNewHomework);
        List<StudentHomework> list = StudentHomeworkJdbc.selectmy(s_id_str);
  
        req.setAttribute("list", list);//在请求里面放了一个list,里面的值是list
        if(null == list || list.size() <= 0)
        {
            req.setAttribute("error", "没有查询到指定数据");//在请求里面放了一个list,里面的值是list
        }
        else
        {
            req.setAttribute("error", "");//在请求里面放了一个list,里面的值是list
        }

        req.getRequestDispatcher("JSP/ShowAllHome.jsp").forward(req, resp);


        //resp.sendRedirect("list");//跳转到list页面
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }


}






