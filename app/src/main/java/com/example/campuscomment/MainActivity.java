package com.example.campuscomment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void firstclick(View view) {
        //显式意图的使用方法实现页面的跳转
        Intent intent=new Intent(MainActivity.this,IndexActivity.class);
        //执行意图
        startActivity(intent);

    }
}