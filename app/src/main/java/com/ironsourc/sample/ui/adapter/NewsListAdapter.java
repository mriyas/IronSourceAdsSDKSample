package com.ironsourc.sample.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ironsourc.sample.R;
import com.ironsourc.sample.model.AdsDummyObject;
import com.ironsourc.sample.model.News;
import com.ironsourc.sample.ui.view_holder.BannerAdsViewHolder;
import com.ironsourc.sample.ui.view_holder.NewsViewHolder;

import java.util.List;

public class NewsListAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<T> mItems;
    final int VIEW_TYPE_ITEM = 0;
    final int VIEW_TYPE_ADS = 1;
    final String TAG=getClass().getSimpleName();
    public NewsListAdapter(List<T> mNews) {
        this.mItems = mNews;
    }

    public void setItems(List<T> mItems) {
        this.mItems = mItems;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        Object item = mItems.get(position);
        if (item instanceof AdsDummyObject) {
            return VIEW_TYPE_ADS;
        } else {
            return VIEW_TYPE_ITEM;

        }

    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        if(viewType==VIEW_TYPE_ADS) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_banner_ads, viewGroup, false);
            return new BannerAdsViewHolder(view);
        }else{
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_news_list, viewGroup, false);
            return new NewsViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {

        if(viewHolder instanceof NewsViewHolder){
            ((NewsViewHolder)viewHolder).bind((News) mItems.get(position),position);
        }else if(viewHolder instanceof BannerAdsViewHolder){
            Log.i(TAG,"BannerAdsUtility>>NewsListAdapter : "+position);
            ((BannerAdsViewHolder)viewHolder).bind(position);

        }
    }

    @Override
    public int getItemCount() {
        return mItems ==null?0: mItems.size();
    }
}
