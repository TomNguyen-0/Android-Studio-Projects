package com.example.myversionofsqlitedatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tom on 7/5/2016.
 */
public class ListChatAdapter extends ArrayAdapter{

    List list = new ArrayList();

    public ListChatAdapter(Context context, int resource)
    {
        super (context,resource);
    }

    static class LayoutHandler{
        TextView CHAT;
    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

public String getString(int position)
{
    ChatProvider dataProvider = (ChatProvider)this.getItem(position);
    return dataProvider.getChat();
}



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        LayoutHandler layoutHandler;
        if(row == null)//checking if the row exist or not
        {
            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout,parent,false);
            layoutHandler = new LayoutHandler();
            layoutHandler.CHAT = (TextView)row.findViewById(R.id.text_message);
            row.setTag(layoutHandler);
        }
        else
        {
            layoutHandler = (LayoutHandler)row.getTag();
        }
        ChatProvider dataProvider = (ChatProvider)this.getItem(position);
        layoutHandler.CHAT.setText(dataProvider.getChat());

        return row;
    }
}
