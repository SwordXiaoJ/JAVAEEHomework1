package com.java.code.class12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
public class DBConnection {
    private static String url="jdbc:mysql://127.0.0.1:3306/school?serverTimezone=GMT&useUnicode=true&characterEncoding=gbk";
    private static String user="root";
    private static String password="199813";
    private static String driverName = "com.mysql.cj.jdbc.Driver";
    static{

        try{
            Class.forName(driverName);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static Connection getConn(){
        Connection conn=null;
        try {
            conn= DriverManager.getConnection(url, user,password);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;
    }

    public static void close(ResultSet rs, PreparedStatement ps, Connection conn) {
        if(rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
