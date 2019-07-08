package com.ironsourc.sample.ui.view_holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ironsourc.sample.R;
import com.ironsourc.sample.model.News;

public class NewsViewHolder extends RecyclerView.ViewHolder {
    TextView tv_title;
    public NewsViewHolder(@NonNull View itemView) {
        super(itemView);
        tv_title=itemView.findViewById(R.id.tv_title);
    }

    public void bind(News news, int position){
        if(news!=null&&tv_title!=null){
            tv_title.setText(news.getTitle());
        }
    }
}
