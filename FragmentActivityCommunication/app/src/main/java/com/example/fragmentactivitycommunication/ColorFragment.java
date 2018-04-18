package com.example.fragmentactivitycommunication;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

/**
 * Created by tom on 7/8/2016.
 */
public class ColorFragment extends Fragment {

    RadioGroup Color_Group;
    OnColorChangedListener onColorChangedListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.color_fragment_layout,container,false);
       Color_Group = (RadioGroup)view.findViewById(R.id.color_group);
        Color_Group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch(checkedId)
                {
                    case R.id.red_id:
                        onColorChangedListener.colorChanged("RED");
                        break;
                    case R.id.blue_id:
                        onColorChangedListener.colorChanged("BLUE");
                        break;
                    case R.id.green_id:
                        onColorChangedListener.colorChanged("GREEN");
                        break;
                }
            }
        });
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            onColorChangedListener = (OnColorChangedListener)activity;
        } catch (Exception ex) {
        }
    }

    public interface  OnColorChangedListener
    {
        public void colorChanged(String color_name);
    }
}
