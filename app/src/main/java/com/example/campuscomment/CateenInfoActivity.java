package com.example.campuscomment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import javaclass.cateen;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;

public class CateenInfoActivity extends AppCompatActivity {
    private TextView cateenname;
    private TextView cateennum;
    private TextView myNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cateen_info);

        //从服务器获取数据
        cateen c = new cateen();
        Double mynum = 0.0;


        Connection conn = null;
            //university_db换成你要连接的数据库名称
            String url = "jdbc:sqlserver://116.204.72.106:3306;DatabaseName=db";
            //sa，root分别为数据库的账号和密码
            //conn = DriverManager.getConnection(url, "root", "Database@123");//getConnection(url, "root", "Database@123");
            System.out.println("success");

            //修改内容
            cateenname = findViewById(R.id.cateenname);
            cateennum = findViewById(R.id.othernumber);
            myNum = findViewById(R.id.myNum);
            cateenname.setText(c.name);
            cateennum.setText(c.num.toString());
            myNum.setText(mynum.toString());
        }


    public void dietInfo(View view) {
        Intent intent=new Intent(CateenInfoActivity.this,DietInfoActivity.class);
        //执行意图
        startActivity(intent);
    }
}