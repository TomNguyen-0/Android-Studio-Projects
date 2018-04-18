package com.example.tabletsandhandsets;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by tom on 7/9/2016.
 */
public class ArticleFragment extends Fragment{
    TextView head_text, desc_text;
    ImageView image_text;
    String[] article;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.article_fragment_layout,container,false);
        View view = inflater.inflate(R.layout.my_fragment_layout,container,false);
        head_text = (TextView)view.findViewById(R.id.heading_text_id);
        desc_text = (TextView)view.findViewById(R.id.desc_id);
        image_text = (ImageView)view.findViewById(R.id.image_text_id);
        image_text.setImageResource(android.R.color.transparent);
        return view;
    }

    public void updateInfo(String Headlines)
    {
        article = getResources().getStringArray(R.array.news_contents);
        if(Headlines.equals("Bank Statement"))
        {
//            image_text.setImageResource(0);
            image_text.setImageResource(R.drawable.when_i_am_rich);
            head_text.setText("Bank Statement");
            desc_text.setText(article[3]); //there is only one article but if you had more then you can set it.
        }
        else if(Headlines.equals("HeadLine 2"))
        {
            image_text.setImageDrawable(null);
            head_text.setText("HeadLine 2");
            desc_text.setText(article[0]);
        }
        else if(Headlines.equals("HeadLine 3"))
        {
            image_text.setImageResource(android.R.color.transparent);
            head_text.setText("News HeadLine 3");
            desc_text.setText(article[0]);
        }
        else if(Headlines.equals("HeadLine 4"))
        {
            image_text.setImageDrawable(null);
            head_text.setText("News HeadLine 4");
            desc_text.setText(article[0]);
        }
        else if(Headlines.equals("President Obama"))
        {
            image_text.setImageResource(R.drawable.obama);
            head_text.setText("News on President Obama");
            desc_text.setText(article[1]);
        }
        else if(Headlines.equals("Louis CK"))
        {
            image_text.setImageResource(R.drawable.louie);
            head_text.setText("Louis CK");
            desc_text.setText(article[2]);
        }

    }
}
