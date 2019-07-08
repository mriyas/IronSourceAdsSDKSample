package com.ironsourc.sample.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.ironsourc.sample.R;
import com.ironsourc.sample.model.AdsDummyObject;
import com.ironsourc.sample.model.News;
import com.ironsourc.sample.ui.adapter.NewsListAdapter;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.IronSource;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class NewsListFragment<T> extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    List<T> mItems=new ArrayList<>();
    RecyclerView rv_newsList;
    NewsListAdapter<T> mNewsListAdapter;


    public static NewsListFragment newInstance(int index) {
        NewsListFragment fragment = new NewsListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_news_list, container, false);

        return root;
    }
    /*@Override
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
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mItems=setNews();
        mNewsListAdapter=new NewsListAdapter<>(mItems);
        rv_newsList=view.findViewById(R.id.rv_newsList);
        rv_newsList.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false));
        rv_newsList.setAdapter(mNewsListAdapter);
    }

    private List<T> setNews() {
        mItems.clear();
        for(int i=0;i<12;i++){
            News news=new News("News Title : "+i,"Today","https://google.com");
            mItems.add((T) news);
        }
        return   insertAds();
    }

    private List<T> insertAds() {
        for(int i=0;i<mItems.size();i++){
            if(i%4==0) {
                AdsDummyObject adsDummyObject = new AdsDummyObject();
                adsDummyObject.setAdsSize(ISBannerSize.BANNER);
                mItems.add(i,(T) adsDummyObject);
            }
        }
        return mItems;

    }
}