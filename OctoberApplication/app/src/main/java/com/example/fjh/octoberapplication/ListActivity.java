package com.example.fjh.octoberapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListActivity extends AppCompatActivity {
    private ListView lv;
    private List<Map<String, Object>> list;
    private int image = R.drawable.time_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        lv = (ListView) findViewById(R.id.List01);
        list = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < 11; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("img", image);
            map.put("bt", "标题---" + i);
            map.put("nr", "内容---" + i);
            list.add(map);
        }

        SimpleAdapter adapter = new SimpleAdapter(ListActivity.this, list, R.layout.list_item,
                new String[]{"img", "bt", "nr"}, new int[]{R.id.list_Image, R.id.list_bt, R.id.list_nr});
        lv.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
       return true;
        // return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_item_Add:
                Toast.makeText(this,"add",Toast.LENGTH_SHORT).show();break;
            case R.id.menu_item_Remove:
                Toast.makeText(this,"Remove",Toast.LENGTH_SHORT).show();break;
        }
        return  true;
        //return super.onOptionsItemSelected(item);
    }
}
