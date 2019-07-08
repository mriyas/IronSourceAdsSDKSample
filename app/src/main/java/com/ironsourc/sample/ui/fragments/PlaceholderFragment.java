package com.ironsourc.sample.ui.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.support.annotation.Nullable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;

import com.ironsourc.sample.R;
import com.ironsourc.sample.ui.ads.BannerAdsUtility;
import com.ironsourc.sample.ui.view_model.PageViewModel;
import com.ironsource.mediationsdk.IronSource;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {
    final String TAG=getClass().getSimpleName();

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;
    int index = 1;
    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);

        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }
   /* @Override
    public void onResume() {
        super.onResume();
        IronSource.onResume(getActivity());
    }
    @Override
    public void onPause() {
        super.onPause();
        IronSource.onPause(getActivity());
    }*/
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        final TextView textView = root.findViewById(R.id.section_label);
        pageViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        final LinearLayout ll_bannerContainer = root.findViewById(R.id.ll_bannerContainer);

        Log.i(TAG,"BannerAdsUtility>>PlaceholderFragment : "+index);
        new BannerAdsUtility().loadAds((Activity) ll_bannerContainer.getContext(),ll_bannerContainer);

        return root;
    }
}