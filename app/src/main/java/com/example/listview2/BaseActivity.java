package com.example.listview2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class BaseActivity extends AppCompatActivity {
    private ListView listView3;
    private ImageView write;
    private List<Msg> list = new ArrayList<>();
    private BaseAdapter adapter;
    private int[] ps ={R.mipmap.profile1,R.mipmap.profile2,R.mipmap.profile3,R.mipmap.profile4,R.mipmap.profile5,
            R.mipmap.profile6,R.mipmap.profile7,R.mipmap.profile8,R.mipmap.profile9};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        listView3 = findViewById(R.id.list_view3);
        write = findViewById(R.id.write);


       //数据源的准备
       initData();

       adapter = new MyAdapter(list,this);

       //设置适配器
        listView3.setAdapter(adapter);


        //新增数据源，发说说的操作
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Msg m = new Msg(R.mipmap.profile9,"joy","这是一条新说说",false);
                list.add(m);
                //通知适配器数据更新
                adapter.notifyDataSetChanged();
                //设置listview自动显示到更新数据
                //TRANSCRIPT_MODE_ALWAYS_SCROLL指的是"无论当前可见什么项目，列表都会自动滚动到底部"
                listView3.setTranscriptMode(AbsListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
            }
        });


    }

    private void initData() {
        for (int i =0;i<9;i++){
            Msg m = new Msg(ps[i],"用户"+(i+1),"今天天气真好",i%2 == 0?true:false);
            list.add(m);
        }

    }
}