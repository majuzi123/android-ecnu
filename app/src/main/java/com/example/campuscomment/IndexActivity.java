package com.example.campuscomment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class IndexActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
    }

    public void searchview(View view) {
        //显式意图的使用方法实现页面的跳转
        Intent intent=new Intent(IndexActivity.this,SearchActivity.class);
        //执行意图
        startActivity(intent);
    }

    public void dailyinfo(View view) {
        Intent intent=new Intent(IndexActivity.this,DailyInfoActivity.class);
        //执行意图
        startActivity(intent);
    }

    public void cateenInfo(View view) {
        Intent intent=new Intent(IndexActivity.this,CateenInfoActivity.class);
        //执行意图
        startActivity(intent);
    }

    public void dietinfo(View view) {
        Intent intent=new Intent(IndexActivity.this,DietInfoActivity.class);
        //执行意图
        startActivity(intent);
    }
}