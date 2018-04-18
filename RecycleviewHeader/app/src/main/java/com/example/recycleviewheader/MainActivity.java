package com.example.recycleviewheader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<ListProvider> arrayList = new ArrayList<ListProvider>();
    String[] Name, Capital;
    int[] img_id = {R.drawable.india,R.drawable.austrlia,R.drawable.uae,R.drawable.thailand,R.drawable.srilanka,R.drawable.netherland,R.drawable.newzeland,R.drawable.malayasia};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        Name = getResources().getStringArray(R.array.country_name);
        Capital = getResources().getStringArray(R.array.capital_city);
        int count = 0;
        for (String NAME : Name)
        {
            ListProvider listProvider = new ListProvider(img_id[count],NAME,Capital[count]);
            arrayList.add(listProvider);
            count++;
        }

        adapter = new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(adapter);
    }
}
