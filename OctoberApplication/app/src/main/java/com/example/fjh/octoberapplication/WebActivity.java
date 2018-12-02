package com.example.fjh.octoberapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toolbar;



public class WebActivity extends AppCompatActivity {
    public WebView WV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //清除标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_web);
        //因为继承的不是Activity，所以添加一个if判断
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        //开始web设置
        WV = (WebView)findViewById(R.id.Web_View);
        WV.getSettings().setJavaScriptEnabled(true);
        WV.setWebViewClient( new WebViewClient());
        WV.loadUrl("https://www.baidu.com/");
//        WV.loadUrl("http://21207f94d3.iok.la:16931/test-02/index.jsp");

    }


}
