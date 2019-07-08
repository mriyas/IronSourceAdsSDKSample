package com.ironsourc.sample.ui.view_holder;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.ironsourc.sample.R;
import com.ironsourc.sample.ui.ads.BannerAdsUtility;

public class BannerAdsViewHolder extends RecyclerView.ViewHolder {
    LinearLayout ll_bannerContainer;
    public BannerAdsViewHolder(@NonNull View itemView) {
        super(itemView);
        ll_bannerContainer=itemView.findViewById(R.id.ll_bannerContainer);
    }
    public void bind(int position){

        new BannerAdsUtility().loadAds((Activity) ll_bannerContainer.getContext(),ll_bannerContainer);

    }
}
