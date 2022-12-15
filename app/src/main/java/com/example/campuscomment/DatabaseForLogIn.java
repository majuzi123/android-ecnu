package com.example.campuscomment;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.mysql.jdbc.MySQLConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;

public class DatabaseForLogIn extends AppCompatActivity {
    private String driver = "com.mysql.jdbc.Driver";
    private String dbURL = "jdbc:mysql://116.204.72.106:3306/db";
    private String user = "root";
    private String password = "Database@123";
    private String uName = null;
    private String uPwd = null;
    DatabaseForLogIn(){}
    public DatabaseForLogIn(String n,String p){
        this.uName = n;
        this.uPwd = p;
    }
    private static DatabaseForLogIn connection = null;
    public static Connection getConnection(){
        Connection conn = null;
        if(connection == null){
            try{
                connection = new DatabaseForLogIn();
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
    public String Query(String name,String pwd){
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
}
