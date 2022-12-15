package com.example.campuscomment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DengluActivity extends AppCompatActivity {
    private Button loginBtn;
    private EditText et_UserName,et_Password;
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denglu);
        init();
        WorkThread wt =new WorkThread();
        wt.start();
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = et_UserName.getText().toString();
                String pwd = et_Password.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("n",uname);
                bundle.putString("p",pwd);
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
                            String name = b.getString("n");
                            String pwd = b.getString("p");
                            DatabaseForUse db = new DatabaseForUse();
                            String ret = db.QueryForLogin(name,pwd);
                            if(ret.equals("1")){
                                Toast.makeText(DengluActivity.this, "登录成功！", Toast.LENGTH_LONG).show();
                                Intent intent=new Intent(DengluActivity.this,IndexActivity.class);
                                //执行意图
                                startActivity(intent);
                                return;
                            }
                            Toast.makeText(DengluActivity.this, "登录失败！", Toast.LENGTH_LONG).show();
                            break;
                    }
                }
            };
            Looper.loop();
        }
    }
    private void init() {
        loginBtn=findViewById(R.id.login);
        et_UserName=findViewById(R.id.userid);
        et_Password=findViewById(R.id.pwd);
    }
    public void myclick2(View view) {
        finish();
    }
}