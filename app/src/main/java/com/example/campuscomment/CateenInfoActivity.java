package com.example.campuscomment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CateenInfoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cateen_info);

        //处理从上一个页面获得的数据
        Intent intent = getIntent();
        String cateenname = intent.getStringExtra("cateenname");

        //页面需要的数据
        cateen c = new cateen();
        food [] f = new food[4];
        f[0] = new food();
        f[1] = new food();
        f[2] = new food();
        f[3] = new food();
        Integer mynum = 0;

        //从数据库获取数据，放到上面的数据库存中
        c.setName(cateenname);

        //调用函数刷新数据
        Update(c,f,mynum);
    }
    //调用这个函数会刷新数据
    public void Update(cateen c,food f[],Integer mynum){
        //从页面获取组件
        TextView cateenname = findViewById(R.id.cateenname);
        TextView othernum = findViewById(R.id.othernumber);
        TextView myNum = findViewById(R.id.myNumber);
        TextView food1 = findViewById(R.id.food1);
        TextView food2 = findViewById(R.id.food2);
        TextView food3 = findViewById(R.id.food3);
        TextView food4 = findViewById(R.id.food4);
        //赋值
        cateenname.setText(c.name);
        othernum.setText(c.num.toString());
        myNum.setText(mynum.toString());
        food1.setText(f[0].name);
        food2.setText(f[1].name);
        food3.setText(f[2].name);
        food4.setText(f[3].name);
    }

    public void dietInfo(View view) {
        Intent intent=new Intent(CateenInfoActivity.this,DietInfoActivity.class);
        //执行意图
        startActivity(intent);
    }
}