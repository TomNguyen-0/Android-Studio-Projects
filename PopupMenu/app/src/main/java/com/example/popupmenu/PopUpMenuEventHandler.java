package com.example.popupmenu;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * Created by tom on 6/24/2016.
 */
public class PopUpMenuEventHandler implements PopupMenu.OnMenuItemClickListener{

    Context context;
    public PopUpMenuEventHandler(Context context)
    {
        this.context = context;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {

        if(item.getItemId()==R.id.id_admin)
        {
            Toast.makeText(context,"Login As Admin",Toast.LENGTH_LONG).show();
            return true;
        }
        else if(item.getItemId() == R.id.id_user)
        {
            Toast.makeText(context, "Login As User",Toast.LENGTH_LONG).show();
            return true;
        }
        return false;
    }
}
