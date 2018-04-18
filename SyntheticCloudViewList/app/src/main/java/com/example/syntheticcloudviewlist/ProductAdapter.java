package com.example.syntheticcloudviewlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tom on 6/20/2016.
 */
public class ProductAdapter extends ArrayAdapter
{
    List list = new ArrayList();
    public ProductAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return this.list.size();
    }

    static class DataHandler
    {
        CheckBox box;
        ImageView image;
        TextView title;
        TextView cost;
    }

    @Override
    public Object getItem(int position)
    {
        return this.list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        row = convertView;
        DataHandler handler;
        if(convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.layout_row,parent,false);
            handler = new DataHandler();
            handler.box = (CheckBox)row.findViewById(R.id.checkbox);
            handler.image = (ImageView)row.findViewById(R.id.product_image);
            handler.title = (TextView)row.findViewById(R.id.product_label);
            handler.cost = (TextView)row.findViewById(R.id.product_cost);
            row.setTag(handler);
        }
        else
        {
            handler = (DataHandler) row.getTag();
        }
        ProductDataProvider dataProvider;
        dataProvider = (ProductDataProvider) this.getItem(position);

        handler.image.setImageResource(dataProvider.getProduct_poster_resource());
        handler.title.setText(dataProvider.getProduct_label());
        handler.cost.setText(dataProvider.getProduct_cost());

        return row;
    }
}
