package com.example.campuscomment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DietInfoActivity extends AppCompatActivity {
    private TextView tvFN;
    private TextView tvAD;
    private TextView tvRK;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_info);
        Intent i = getIntent();
        String ret = i.getStringExtra("result");
        String str[] = ret.split(" ");
        System.out.println(str[1]);
        System.out.println(str[2]);
        tvFN.setText(str[0]);
        tvAD.setText(str[1]);
        tvRK.setText(str[2]);
    }
}