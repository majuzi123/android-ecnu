package com.example.campuscomment;

import androidx.annotation.WorkerThread;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DietInfoActivity extends AppCompatActivity {
    private TextView tvFN;
    private TextView tvAD;
    private TextView tvRK;
    private Button btn;
    private EditText ed;
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_info);
        Intent i = getIntent();
        String ret = i.getStringExtra("result");
        String str[] = ret.split(" ");
        System.out.println(str[0]);
        System.out.println(str[1]);
        System.out.println(str[2]);
        System.out.println(str[3]);
        tvFN = findViewById(R.id.fname);
        tvAD = findViewById(R.id.address);
        tvRK = findViewById(R.id.otherR);
        tvFN.setText(str[1]);
        tvAD.setText(str[2]);
        tvRK.setText(str[3]);
        btn = findViewById(R.id.mark_button);
        ed = findViewById(R.id.edit_mark);
        WorkThread wt = new WorkThread();
        wt.start();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mark = ed.getText().toString();
                mark += " ";
                mark += str[0];
                Bundle bundle = new Bundle();
                bundle.putString("m",mark);
                Message m = handler.obtainMessage();
                m.setData(bundle);
                m.what = 0;
                handler.sendMessage(m);
            }
        });

        }
    class WorkThread extends Thread{
        @Override
        public void run(){
            Looper.prepare();
            handler = new Handler(Looper.getMainLooper()){
                @Override
                public void handleMessage(Message m){
                    switch (m.what){
                        case 0:
                            Bundle b = m.getData();
                            String str = b.getString("m");
                            DatabaseForUse db = new DatabaseForUse();
                            String ret = db.InsertForMark(str);
                            if(ret.equals("1")){
                                Toast.makeText(DietInfoActivity.this, "评价成功！", Toast.LENGTH_LONG).show();
                                return;
                            }
                            Toast.makeText(DietInfoActivity.this, "评价失败！", Toast.LENGTH_LONG).show();
                            break;
                    }
                }
            };
            Looper.loop();
        }
    }
}