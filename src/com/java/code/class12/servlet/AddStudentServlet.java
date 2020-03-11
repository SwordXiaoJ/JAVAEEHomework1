package com.java.code.class12.servlet;

import com.java.code.class12.jdbc.StudentHomeworkJdbc;
import com.java.code.class12.jdbc.StudentJdbc;
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


@WebServlet("/addstudent")
public class AddStudentServlet extends HttpServlet {

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
        String s_name=req.getParameter("s_name");



        Timestamp dateNow=new Timestamp(System.currentTimeMillis());

        Student student = new Student(s_id,s_name,dateNow,dateNow);



        StudentJdbc.addStudent(student);
        List<Student> list = StudentJdbc.selectAllStu();


        req.setAttribute("list", list);//在请求里面放了一个list,里面的值是list

        req.getRequestDispatcher("JSP/Teacher/ShowAllStu.jsp").forward(req, resp);


    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }


}
