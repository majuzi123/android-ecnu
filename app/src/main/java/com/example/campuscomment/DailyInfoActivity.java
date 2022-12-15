package com.example.campuscomment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DailyInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_info);
    }

    public void dietInfo(View view) {
        Intent intent=new Intent(DailyInfoActivity.this,DietInfoActivity.class);
        //执行意图
        startActivity(intent);
    }
}