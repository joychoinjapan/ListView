package com.example.listview2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ArrayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array);
        ListView listView1 = findViewById(R.id.list_view1);


        /**
         * 参数1 环境上下文 this
         * 参数2 代表数据项所应用的布局
         * 参数3 数据源 数组等
         */
        String[] data = {"AA", "BB", "CC", "DD", "AA", "BB", "CC", "DD", "AA", "BB", "CC", "DD"};
//        ArrayAdapter arrayAdapter = new ArrayAdapter(this,R.layout.item,data);
//        listView1.setAdapter(arrayAdapter);


        /**
         * 使用Android自带的资源
         */
//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,data);
//        listView1.setAdapter(adapter);

        /**
         * 不使用自带资源
         */

        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.item2, R.id.txt1, data);
        listView1.setAdapter(adapter);

    }

}