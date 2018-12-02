package com.example.fjh.octoberapplication;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class HandlerActivity extends AppCompatActivity {
    TextView textView1;
    ImageView imageView1;
    Handler handler,handler1,handler2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        textView1 = findViewById(R.id.HandlerTest2Text);
        imageView1 = findViewById(R.id.HandlerTest3Images);
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
            }
        };

         handler1 = new Handler(){
            @Override
            public void handleMessage(android.os.Message msg) {
                super.handleMessage(msg);
                textView1.setText("成功更改");
            };
        };
        handler2 = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                //super.handleMessage(msg);
                imageView1.setImageResource(R.drawable.ic_audiotrack_dark);
            }
        };
    }




    public void changeView(View view){
        if (view.getId()==R.id.HandlerTextButton){
            //textView1.setText("主线程更改");
            //创建子线程
            new Thread(){
                @Override
                public void run() {
                  handler.post(new Runnable() {
                      @Override
                      public void run() {
                          textView1.setText("成功更改");
                      }
                  });

                }
            }.start();
            Toast.makeText(this,"changeText",Toast.LENGTH_SHORT).show();
        }else if (view.getId()==R.id.HandlerImagesButton){
            new Thread(){
                @Override
                public void run() {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            imageView1.setImageResource(R.drawable.icon);
                        }
                    });
                }
            }.start();
            Toast.makeText(this,"changeIamges",Toast.LENGTH_SHORT).show();
        }
    }
}
