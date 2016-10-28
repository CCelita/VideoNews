package com.fuicuiedu.idedemo.videonews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2016/10/28 0028.
 */

public class RecyclerAdapter extends RecyclerView.Adapter {

    private List<String> mDatas;
    private Context context;
    private LayoutInflater inflater;//填充器，用来填充布局

    public RecyclerAdapter(Context context,List<String> mDatas){
        this.context = context;
        this.mDatas = mDatas;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
