package com.example.listview2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


//根据准备好的数据源和子项布局完成ListView效果的一一设置
//做出一些细节处理
public class MyAdapter extends BaseAdapter {
    private List<Msg> list;
    private Context ctx;

    public MyAdapter(List<Msg> list,Context ctx){
        this.list = list;
        this.ctx = ctx;
    }


    //获取数量（设置listview的长度）
    @Override
    public int getCount() {
        return list.size();
    }


    //设置listview的每一项的显示效果

    /**
     *
     * @param position 索引
     * @param convertView 视图本身
     * @param parent 父容器
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //完成对view的设置
        //将布局资源转为view

        /**
         * 所需要的布局资源
         */
        convertView = LayoutInflater.from(ctx).inflate(R.layout.item4,null);
        Msg m = list.get(position);
        //头像
        ImageView profile = convertView.findViewById(R.id.profile);
        profile.setImageResource(m.getProfile());
        //昵称
        TextView nickname = convertView.findViewById(R.id.nickname);
        nickname.setText(m.getNickname());

        //内容
        TextView content = convertView.findViewById(R.id.content);
        content.setText(m.getContent());

        //是否点赞
        ImageView isLike = convertView.findViewById(R.id.isLike);
        if(m.isLike()){
            isLike.setImageResource(R.mipmap.liked);
        }else{
            isLike.setImageResource(R.mipmap.like);
        }

        //设置点击事件
        ImageView repost = convertView.findViewById(R.id.repost);
        repost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctx,"转发",Toast.LENGTH_SHORT).show();
            }
        });


        ImageView comment = convertView.findViewById(R.id.comment);
        comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctx,"=========评论==========",Toast.LENGTH_SHORT).show();
            }
        });


        return convertView;
    }

    //获取子项
    @Override
    public Object getItem(int position) {
        return null;
    }

    //获取子项id
    @Override
    public long getItemId(int position) {
        return 0;
    }


}
