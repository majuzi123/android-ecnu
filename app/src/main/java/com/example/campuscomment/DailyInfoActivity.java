package com.example.campuscomment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

public class DailyInfoActivity extends AppCompatActivity {
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_info);
        WorkThread wt = new WorkThread();
        wt.start();
    }

    public void dietInfo(View view) {
        //执行意图
        TextView t = (TextView)view;
        String sth = t.getText().toString();
        Bundle bundle = new Bundle();
        bundle.putString("sth",sth);
        Message m = handler.obtainMessage();
        m.setData(bundle);
        m.what = 0;
        handler.sendMessage(m);
    }
    class WorkThread extends Thread{
        @Override
        public void run(){
            Looper.prepare();
            handler = new Handler(Looper.getMainLooper()){
                @Override
                public void handleMessage(Message m){
                    if (m.what==0){
                        Bundle b = m.getData();
                        String sth = b.getString("sth");
                        DatabaseForUse db = new DatabaseForUse();
                        String ret = db.QueryForSearch(sth);
                        Intent intent=new Intent(DailyInfoActivity.this,DietInfoActivity.class);
                        intent.putExtra("result",ret);
                        //执行意图
                        startActivity(intent);
                        return;
                    }
                }
            };
            Looper.loop();
        }
    }
}