package com.example.listview2;

import android.content.Context;
import android.util.Log;
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
     * 每个视图出现时 执行
     * @param position 索引
     * @param convertView 视图本身
     * @param parent 父容器
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //完成对view的设置
        //将布局资源转为view

        ViewHolder holder;




        /**
         * 所需要的布局资源
         */
        //RecycleBin回收站 下拉后 在上面的元素会被回收，所以只需要在第一次加载的时候将view生成
        if(convertView == null){
            Log.v("TAG","===================--"+position);
            //优化1 利用进入RecycleBin中的View，减少对view的赋值
            convertView = LayoutInflater.from(ctx).inflate(R.layout.item4,null);
            holder = new ViewHolder();
            holder.profile = convertView.findViewById(R.id.profile);
            holder.nickname = convertView.findViewById(R.id.nickname);
            holder.content = convertView.findViewById(R.id.content);
            holder.isLike = convertView.findViewById(R.id.isLike);
            holder.repost = convertView.findViewById(R.id.repost);
            holder.comment = convertView.findViewById(R.id.comment);
            convertView.setTag(holder);
        }else{
            //通过getTag取出ViewHoldr对象，然后通过直接通过holder控件的方式在外面直接操作控件
            //从而避免了大幅度使用findViewById操作getTag操作效率高
            holder = (ViewHolder) convertView.getTag();

        }
        Msg m = list.get(position);
        //头像
        //ImageView profile = convertView.findViewById(R.id.profile);
        holder.profile.setImageResource(m.getProfile());
        //昵称
        //TextView nickname = convertView.findViewById(R.id.nickname);
        holder.nickname.setText(m.getNickname());

        //内容
        //TextView content = convertView.findViewById(R.id.content);
        holder.content.setText(m.getContent());

        //是否点赞
        //ImageView isLike = convertView.findViewById(R.id.isLike);
        if(m.isLike()){
            holder.isLike.setImageResource(R.mipmap.liked);
        }else{
            holder.isLike.setImageResource(R.mipmap.like);
        }

        //设置点击事件
        //ImageView repost = convertView.findViewById(R.id.repost);
        holder.repost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctx,"转发",Toast.LENGTH_SHORT).show();
            }
        });


        //ImageView comment = convertView.findViewById(R.id.comment);
        holder.comment.setOnClickListener(new View.OnClickListener() {
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

    //1.自定义内部类
    //2.viewsHolder将需要保存的视图声明为公开的属性
    //3.什么时候保存 当view为空时
    //4.什么时候用 什么时候都要用
    //5.怎么用 当view为null时，完成了viewholder及内部控件属性的初始化工作后调用view.setTag(holder);
        //当view不为null时，holder = view.getTag()
    static class ViewHolder{
        public ImageView profile,isLike,comment,repost;
        public TextView nickname,content;
    }



}
