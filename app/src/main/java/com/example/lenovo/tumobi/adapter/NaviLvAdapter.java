package com.example.lenovo.tumobi.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.tumobi.R;
import com.example.lenovo.tumobi.model.bean.home_bean.Frist_Bean;


import java.util.ArrayList;

/**
 * Created by lenovo on 2019/6/24.
 */

public class NaviLvAdapter extends RecyclerView.Adapter<NaviLvAdapter.ViewHolder>{

    private Context content;
    private ArrayList<Frist_Bean.DataBean.BrandListBean> list;

    public NaviLvAdapter(Context content, ArrayList<Frist_Bean.DataBean.BrandListBean> list) {
        this.content = content;
        this.list = list;
    }

    public NaviLvAdapter(FragmentActivity activity, ArrayList<Frist_Bean.DataBean.BrandListBean> list) {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = View.inflate(content, R.layout.item_navi, null);
        ViewHolder holder = new ViewHolder(view);

        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Glide.with(content).load(list.get(position).getPic_url()).into(holder.img);

        holder.zi1.setText(list.get(position).getName());
        holder.zi2.setText(list.get(position).getFloor_price());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView img;
        private TextView zi1;
        private TextView zi2;

        public ViewHolder(View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.navi_img);
            zi1 = itemView.findViewById(R.id.navi_tv1);
            zi2 = itemView.findViewById(R.id.navi_tv2);
        }
    }

}