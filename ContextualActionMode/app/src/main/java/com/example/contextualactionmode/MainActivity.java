package com.example.contextualactionmode;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    ActionMode actionMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView)findViewById(R.id.image_view);

        imageView.setOnLongClickListener(new View.OnLongClickListener() {//set the longClickListener to this image
            @Override
            public boolean onLongClick(View v) {
                if(actionMode != null)//checks to see if this is already running.
                {
                    return false;
                }
                else
                {
                    actionMode = MainActivity.this.startActionMode( callback);


                    return true;
                }

            }


        });

    }


    private ActionMode.Callback callback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.my_menu,menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            mode.setTitle("1 Item selected");
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            if(item.getItemId()==R.id.id_delete)
            {
                Toast.makeText(getApplicationContext(),"are you sure you want to delete?",Toast.LENGTH_LONG).show();
                return true;
            }
            else if(item.getItemId()==R.id.id_share)
            {
                Toast.makeText(getApplicationContext(),"You are about to share this image.",Toast.LENGTH_LONG).show();
                return true;
            }
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            actionMode = null;
        }
    };
}
