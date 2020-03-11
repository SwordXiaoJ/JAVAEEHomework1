package com.java.code.class12.jdbc;

import com.java.code.class12.DBConnection;
import com.java.code.class12.model.Student;
import com.java.code.class12.model.StudentHomework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentJdbc {
    public static List<Student> selectAllStu()
    {



        String sqlString = "SELECT * FROM s_student";

        Connection conn= DBConnection.getConn();
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Student> list = new ArrayList<>();
        try
        {
            ps=conn.prepareStatement(sqlString);
            rs=ps.executeQuery(sqlString);
            // 获取执行结果
            while (rs.next()){
                Student stu = new Student();
                stu.setId(rs.getLong("student_id"));
                stu.setName(rs.getString("name"));
                stu.setCreateTime(rs.getTimestamp("create_time"));
                stu.setUpdateTime(rs.getTimestamp("update_time"));

                list.add(stu);
            }
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            DBConnection.close(rs, ps, conn);
        }


        return list;

    }
    public static void addStudent(Student student){



        Connection conn= DBConnection.getConn();
        String sql = "insert into s_student values (?,?,?,?)";

        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            //��������ֵ
            ps.setLong(1,student.getId());
            ps.setString(2,student.getName());
            ps.setTimestamp(3,student.getCreateTime());
            ps.setTimestamp(4,student.getUpdateTime());


            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBConnection.close(null, ps, conn);
        }
    }
}
