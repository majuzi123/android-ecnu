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
     private TextView tv;
     String a="测试完毕";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.tv);

    }

    public void firstclick(View view) {
        //显式意图的使用方法实现页面的跳转
        Intent intent=new Intent(MainActivity.this,IndexActivity.class);
        //执行意图
        startActivity(intent);

    }
    private void sendRequestWithHttpURLConnection() {
        // 开启线程来发起网络请求
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                try {
                    Log.d("MainActivity", "HttpURLConnection connecting ");
                    URL url = new URL("https://www.baidu.com");
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(180000);
                    connection.setReadTimeout(180000);
                    InputStream in = connection.getInputStream();
                    //下面对获取到的输入流进行读取
                   reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder response = new StringBuilder();
                    String line;
                    Log.d("MainActivity", "HttpURLConnection get result ");
                   while ((line = reader.readLine()) != null) {
                        response.append(line);
                  }
                   Log.d("MainActivity", "display result ");
                    Log.d("MainActivity", response.toString());
                   showResponse(response.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (connection != null) {
                        connection.disconnect();
                    }
                }
            }
        }).start();
    }
    private void showResponse(final String response) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // 在这里进行UI操作，将结果显示到界面上
                tv.setText(response);
            }
        });
    }

    public void changeText(View view) {
        //tv.setText(a);
        sendRequestWithHttpURLConnection();
    }
}