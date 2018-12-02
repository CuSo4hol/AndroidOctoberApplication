package com.example.fjh.octoberapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private SharedPreferences users;
    CheckBox cb=null;
    boolean mm=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        jc();
        checkBox();
    }
    //取出已经记住密码的缓存
    public void jc(){
        //获取输入框
        EditText password=(EditText)findViewById(R.id.password);
        EditText name=(EditText)findViewById(R.id.name);

        //获取Preferences
        users = getSharedPreferences("user", 0);
        //取出数据
        String Stpassword=users.getString("password","");
        String Stname=users.getString("name","");

        password.setText(Stpassword);
        name.setText(Stname);

    }

    //复选框监听
    public void checkBox(){
        //获得CheckBox示例
        cb=(CheckBox)findViewById(R.id.cb);
        //绑定监听器
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mm=isChecked;
            }
        });
    }


    public void click(View view) {
        Button qk = (Button) findViewById(R.id.qkbut);
        Button login = (Button) findViewById(R.id.loginbut);
        EditText name = (EditText) findViewById(R.id.name);
        EditText password = (EditText) findViewById(R.id.password);

        //清空按钮
        if (view.getId() == R.id.qkbut) {
            Toast.makeText(this, "已清空", Toast.LENGTH_LONG).show();
            name.setText("");
            password.setText("");
        }
        //登陆按钮
        else if (view.getId() == R.id.loginbut) {
            if (name.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
                //判断是否记住密码
                if(mm) {
                    //开始存入缓存账户密码


                    // 打开名称为users的Preferences，如果存在则打开它，否则创建新的Preferences

                    //在users这个Preferences中创建一个name为user的键值对组（具体这个uesr名字是啥忘记了，，反正它里面存的是一个个的键值对组，就暂且叫它这个了）
                    users = getSharedPreferences("user", 0);
                    //让users处于编辑状态
                    SharedPreferences.Editor User = users.edit();
                    //获取当前EditText中的文字
                    EditText name1 = (EditText) findViewById(R.id.name);
                    EditText password1 = (EditText) findViewById(R.id.password);
                    //存放数据（键值对的形式，如第一个键为“name”，值就是name1.getText().toString()）
                    User.putString("name", name1.getText().toString());
                    User.putString("password", password1.getText().toString());
                    //提交
                    User.commit();
                    //Toast.makeText(LoginActivity.this, "成功记住密码", Toast.LENGTH_LONG).show();
                }
                //页面跳转
                Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
                //传递值给下一个activity页面并跳转
                Intent i = new Intent(LoginActivity.this, HelloActivity.class);
                ////传递值
                i.putExtra("name", name.getText().toString());
                i.putExtra("password", password.getText().toString());
                //清空本页面
                name.setText("");
                password.setText("");
                //销毁当前界面
                finish();
                //开始跳转
                startActivity(i);


            } else {
                Toast.makeText(this, "账户或密码错误，请重新输入", Toast.LENGTH_LONG).show();
                name.setText("");
                password.setText("");
            }

        }
    }
}
