package com.example.fjh.octoberapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class HelloActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_hello);

        //接受上一个activity传的值
        Intent i = getIntent();
        String name = i.getStringExtra("name");
        //赋值给TextView02
        ((TextView)findViewById(R.id.text02)).setText(name);
        //  Toast.makeText(this,name,Toast.LENGTH_LONG).show();
    }
    public void change(View view) {
        if(view.getId()==R.id.ListButton){
            Intent i = new Intent(this,ListActivity.class);
            startActivity(i);
        }else if (view.getId()==R.id.RecButton){
            Intent i = new Intent(this,RecyclerViewActivity.class);
            startActivity(i);
        }
        else if (view.getId()==R.id.WebButton){
        Intent i = new Intent(this,WebActivity.class);
        startActivity(i);
        }
        else if (view.getId()==R.id.BaiduButton){
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://www.baidu.com/"));
            startActivity(i);
        }else if (view.getId()==R.id.HandlerButton){
            Intent i = new Intent(this,HandlerActivity.class);
            startActivity(i);
        }
    }
}
