package com.example.tabletsandhandsets;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by tom on 7/9/2016.
 */
public class HeadlineFragment extends Fragment {

    ListView listView;
    ArrayAdapter<String> adapter;
    String[] headlines;
    OnHeadLineClickListener onHeadLineClickListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.headline_fragment_layout,container,false);
        listView = (ListView)view.findViewById(R.id.list_headline);
        headlines = getResources().getStringArray(R.array.news_titles);
        adapter = new ArrayAdapter<String>(getActivity(),R.layout.headline_list_layout,R.id.row_item,headlines);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String Heading = headlines[position];
                onHeadLineClickListener.headlineSelected(Heading);
            }
        });
        return view;
    }

    public interface OnHeadLineClickListener
    {
        public void headlineSelected(String headline);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try
        {
            onHeadLineClickListener = (OnHeadLineClickListener)activity;
        }catch (Exception e){}
    }
}
