package com.example.youtubetodollist;

        import android.content.DialogInterface;
        import android.inputmethodservice.KeyboardView;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.KeyEvent;
        import android.view.View;
        import android.widget.ArrayAdapter;
        import android.widget.EditText;
        import android.widget.ListView;
        import android.widget.Toast;

        import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText myEditText = (EditText)findViewById(R.id.myEditText);
        ListView myListView = (ListView)findViewById(R.id.myListView);

        final ArrayList<String> todoItems = new ArrayList<String>();

        final ArrayAdapter<String> aa = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                todoItems);

        myListView.setAdapter(aa);

        myEditText.setOnKeyListener(new View.OnKeyListener(){
            public boolean onKey(View v, int keyCode, KeyEvent event){
                if (event.getAction() == KeyEvent.ACTION_DOWN){
                    if (keyCode == KeyEvent.KEYCODE_NUMPAD_ENTER){
                        todoItems.add(0, myEditText.getText().toString());

                        aa.notifyDataSetChanged();

                        myEditText.setText("");

                        return true;
                    }
                }
                return false;
            }
        });
    }

    public boolean onButtonTap(View v){
        Toast myToast = Toast.makeText(
                getApplicationContext(), "Enter something else :)", Toast.LENGTH_LONG);
        myToast.show();

        return true;
    }
}