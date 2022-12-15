package com.example.campuscomment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void myclick1(View view) {
        //显式意图的使用方法实现页面的跳转
        Intent intent=new Intent(MainActivity.this,DengluActivity.class);
        //执行意图
        startActivity(intent);

    }



    public void myclick3(View view) {
        Intent intent=new Intent(MainActivity.this,ZhuceActivity.class);
        //执行意图
        startActivity(intent);
    }


}