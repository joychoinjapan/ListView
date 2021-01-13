package com.example.listview2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.listview2.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleActivity extends AppCompatActivity {

    private List<Map<String,Object>> data = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);

        //获取ListView对象
        ListView listView2 = findViewById(R.id.list_view2);

        //实例化适配器对象
        /**
         * 参数1 this
         * 参数2 数据源
         * 参数3 每一项布局
         * 参数4 数据来源的key数组 String[] from = {"img","name","mode"}
         * 参数5 数据要加入的id数组 int[] to ={R.id.qq_img,R.id.qq_name,R.id.qq_mood}
         */
        initData();
        String[] from = {"img","name","mode"};
        int[] to ={R.id.qq_img,R.id.qq_name,R.id.qq_mood};


        SimpleAdapter adapter = new SimpleAdapter(this,data,R.layout.item3,from,to);

        //为ListView设置适配器
        listView2.setAdapter(adapter);

        //点击事件
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Name //MOOD
                /**
                 * position 为
                 */
                Map<String,Object> map = data.get(position);
                String name = map.get("name").toString();
                String mood = map.get("mood").toString();
                Toast.makeText(SimpleActivity.this,name+" "+mood,Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initData() {
        //左边：头像 右上：名字 右下 心情
        Map<String,Object> map1= new HashMap<>();
        map1.put("img", R.mipmap.caocao);
        map1.put("name","曹操");
        map1.put("mood","宁教我负天下人，休教天下人负我");

        Map<String,Object> map2= new HashMap<>();
        map2.put("img",R.mipmap.zhenji);
        map2.put("name","甄姬");
        map2.put("mood","飘摇兮若流风之回雪");

        Map<String,Object> map3= new HashMap<>();
        map3.put("img",R.mipmap.simayi);
        map3.put("name","司马懿");
        map3.put("mood","无奈天命之子");

        Map<String,Object> map4= new HashMap<>();
        map4.put("img",R.mipmap.guojia);
        map4.put("name","郭嘉");
        map4.put("mood","哦？");

        data.add(map1);
        data.add(map2);
        data.add(map3);
        data.add(map4);
    }
}