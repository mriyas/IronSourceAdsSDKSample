package com.ironsourc.sample.ui.ads;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.BannerListener;

public class BannerAdsUtility {
    final String TAG=getClass().getSimpleName();
    public void loadAds(final Activity activity, final LinearLayout bannerContainer){

        Log.d(TAG,TAG+ ">"+"loadAds() : "+this);
        IronSource.init(activity, "973b9c1d", IronSource.AD_UNIT.BANNER);

        IronSourceBannerLayout banner = IronSource.createBanner(activity, ISBannerSize.BANNER);
        bannerContainer.removeAllViews();

        bannerContainer.addView(banner);

        banner.setBannerListener(new BannerListener() {
            @Override
            public void onBannerAdLoaded() {
                Log.i(TAG,TAG+ ">"+"loadAds() > onBannerAdLoaded()>> Banner Loaded  ");
            }

            @Override
            public void onBannerAdLoadFailed(IronSourceError error) {
                Log.e(TAG,TAG+ ">"+"loadAds() > onBannerAdLoadFailed()>> Banner Failed To Load :   "+error.getErrorMessage());
                // Called after a banner has attempted to load an ad but failed.
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        bannerContainer.removeAllViews();
                    }
                });
            }

            @Override
            public void onBannerAdClicked() {
                Log.d(TAG,TAG+ ">"+"loadAds() > onBannerAdClicked()>> Banner Clicked  ");
            }

            @Override
            public void onBannerAdScreenPresented() {
                Log.d(TAG,TAG+ ">"+"loadAds() > onBannerAdScreenPresented()>> Banner Ad Screen Presented  ");
            }

            @Override
            public void onBannerAdScreenDismissed() {
                Log.d(TAG,TAG+ ">"+"loadAds() > onBannerAdScreenDismissed()>> Banner Ad Screen Dismissed  ");
            }

            @Override
            public void onBannerAdLeftApplication() {
                Log.d(TAG,TAG+ ">"+"loadAds() > onBannerAdLeftApplication()>> Banner Ad Left Application  ");
            }
        });

        IronSource.loadBanner(banner);
    }
}
