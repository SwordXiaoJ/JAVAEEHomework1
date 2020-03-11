package com.java.code.class12.servlet;

import com.java.code.class12.jdbc.NeedHomeworkJdbc;
import com.java.code.class12.jdbc.StudentHomeworkJdbc;
import com.java.code.class12.jdbc.StudentJdbc;
import com.java.code.class12.model.NeedHomework;
import com.java.code.class12.model.Student;
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


@WebServlet("/addhomework")
public class AddHomeworkServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        /**
         * 赋值
         */
        Date create_t = null;

        List<NeedHomework> temp = NeedHomeworkJdbc.selectAllNeed();
        int allid=temp.size();
        allid+=1;
        String allidstr=String.valueOf(allid);
        Long id =Long.parseLong(allidstr);

        String h_id_str=req.getParameter("h_id");
        Long h_id=Long.parseLong(h_id_str);



        String h_titile=req.getParameter("h_title");
        String h_content=req.getParameter("h_content");


        Timestamp dateNow=new Timestamp(System.currentTimeMillis());

        NeedHomework needHomework = new NeedHomework(h_id,h_titile,h_content,dateNow,dateNow);



        NeedHomeworkJdbc.addNeedHomework(needHomework);



        List<NeedHomework> list = NeedHomeworkJdbc.selectAllNeed();

        System.out.println(list);

        req.setAttribute("list", list);//在请求里面放了一个list,里面的值是list

        req.getRequestDispatcher("JSP/Teacher/ShowNeedSub.jsp").forward(req, resp);



    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }


}
