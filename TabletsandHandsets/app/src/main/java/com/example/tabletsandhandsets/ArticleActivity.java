package com.example.tabletsandhandsets;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;


public class ArticleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.article_activity_layout);
        String Heading;
        Intent intent = getIntent();
        Heading = intent.getStringExtra("headline");
        ArticleFragment articleFragment = (ArticleFragment)getFragmentManager().findFragmentById(R.id.article_frag);
        articleFragment.updateInfo(Heading);
    }

}
