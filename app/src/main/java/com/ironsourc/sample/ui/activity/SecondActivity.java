package com.ironsourc.sample.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;

import com.ironsourc.sample.R;
import com.ironsourc.sample.ui.ads.BannerAdsUtility;

public class SecondActivity extends AppCompatActivity {
    final String TAG=getClass().getSimpleName();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        final LinearLayout ll_bannerContainer = findViewById(R.id.ll_bannerContainer);

        Log.i(TAG,"BannerAdsUtility>>PlaceholderFragment : "+TAG);
        new BannerAdsUtility().loadAds((Activity) ll_bannerContainer.getContext(),ll_bannerContainer);

    }
}
