package com.example.campuscomment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.TestLooperManager;
import android.widget.TextView;

import javaclass.diet;

public class DietInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_info);
        //从服务器获取数据
        diet d = new diet();
        Double myNum = 0.0;
        //数据渲染
        TextView name = findViewById(R.id.foodname000);
        TextView address = findViewById(R.id.address);
        TextView num = findViewById(R.id.othernum);
        TextView mynum = findViewById(R.id.myNum1);
        name.setText(d.getName());
        address.setText(d.getCateen());
        num.setText(d.getNum().toString());
        mynum.setText(myNum.toString());
    }
}