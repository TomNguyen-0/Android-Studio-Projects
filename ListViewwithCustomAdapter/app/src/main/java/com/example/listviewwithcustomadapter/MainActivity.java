package com.example.listviewwithcustomadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    int[] movie_poster_resource = {R.drawable.movie_1,
            R.drawable.movie_2,
            R.drawable.movie_3,
            R.drawable.movie_4,
            R.drawable.movie_5,
            R.drawable.movie_6,
            R.drawable.movie_7,
            R.drawable.movie_8,
            R.drawable.movie_9,
            R.drawable.movie_10};
    String[] movie_titles;
    String[] movie_ratings;
    MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.list_view);
        movie_ratings = getResources().getStringArray(R.array.movie_ratings);
        movie_titles = getResources().getStringArray(R.array.movie_titles); //get source from the value strings.xml movie_titles
        int i=0;
        adapter = new MovieAdapter(getApplicationContext(),R.layout.row_layout);
        listView.setAdapter(adapter);
        for(String titles: movie_titles)
        {
            MovieDataProvider dataProvider = new MovieDataProvider(movie_poster_resource[i],
                    titles,movie_ratings[i]);
            adapter.add(dataProvider);
            i++;
        }
    }
}
