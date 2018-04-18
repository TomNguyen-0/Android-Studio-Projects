package com.example.communicationbetweentwofragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by tom on 7/8/2016.
 */
public class FragmentTwo extends Fragment {
    TextView textView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two_layout,container,false);
        textView = (TextView)view.findViewById(R.id.display_name);
        textView.setVisibility(View.GONE);
        return view;
    }

    public void updateInfo(String name)
    {
        textView.setText("Weclome " + name);
        textView.setVisibility(View.VISIBLE);
    }
}
