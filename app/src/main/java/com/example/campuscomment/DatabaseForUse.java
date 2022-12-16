package com.example.campuscomment;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseForUse extends AppCompatActivity {
    private String driver = "com.mysql.jdbc.Driver";
    private String dbURL = "jdbc:mysql://116.204.72.106:3306/db";
    private String user = "root";
    private String password = "Database@123";
    private String uName = null;
    private String uPwd = null;
    DatabaseForUse(){}
    public DatabaseForUse(String n, String p){
        this.uName = n;
        this.uPwd = p;
    }
    private static DatabaseForUse connection = null;
    public static Connection getConnection(){
        Connection conn = null;
        if(connection == null){
            try{
                connection = new DatabaseForUse();
            } catch (Exception e){
                e.printStackTrace();
                return null;
            }
        }
        try {
            Class.forName(connection.driver).newInstance();
            System.out.println("驱动加载成功");

        } catch (Exception e){
            e.printStackTrace();
        }
        try{
            conn = DriverManager.getConnection(connection.dbURL,connection.user, connection.password);
            System.out.println("数据库连接成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public String QueryForLogin(String name,String pwd){
        String result = "";
        try{
            Connection conn = getConnection();
            if(conn != null) {
                String sql = "select name from user_info where name='" + name + "' and pwd='" + pwd + "'";
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    result = "1";
                }
                rs.close();
                conn.close();
            }
        } catch (Exception e){
            e.printStackTrace();
            result += "error!";
        }
        return result;
    }
    public String QueryForSearch(String sth){
        String result = "";
        float rank;
        int mid;
        try{
            Connection conn = getConnection();
            if(conn != null) {
                String sql = "select * from meal where name = '" + sth + "'";
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    mid = rs.getInt("mid");
                    result += Integer.toString(mid);
                    result += " ";
                    result += rs.getString("name");
                    result += " ";
                    result += rs.getString("address");
                    result += " ";
                    rank = rs.getFloat("rank");
                    result += Float.toString(rank);
                    break;
                }
                rs.close();
                conn.close();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    public String InsertForMark(String mark){
        String result = "1";
        String str[] = mark.split(" ");
        int uid = Integer.parseInt(str[1]);
        int mk = Integer.parseInt(str[0]);
        try{
            Connection conn = getConnection();
            if(conn != null) {
                String sql = "INSERT INTO mealcomm (mid,comment) values ("+uid+","+mk+")";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.execute(sql);
                conn.close();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
