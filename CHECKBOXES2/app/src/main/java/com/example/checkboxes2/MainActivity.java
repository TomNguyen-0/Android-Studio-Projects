package com.example.checkboxes2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> selection = new ArrayList<String>();
    TextView final_text;

    private CheckBox check1,check2,check3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final_text = (TextView)findViewById(R.id.final_result);
        final_text.setEnabled(false);
      //  addListenerToCheckBox();
    }
    public void addListenerToCheckBox() {
        check1 = (CheckBox) findViewById(R.id.fruit_apple);
        check2 = (CheckBox) findViewById(R.id.fruit_orange);
        check3 = (CheckBox) findViewById(R.id.fruit_grapes);
        check1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (((CheckBox) v).isChecked()) {
                            Toast.makeText(MainActivity.this, "Tom is selected", Toast.LENGTH_SHORT).show();
                        } else
                            Toast.makeText(MainActivity.this, "Tom is unselected", Toast.LENGTH_SHORT).show();

                    }
                });
        check2.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        if(((CheckBox)v).isChecked()){
                            Toast.makeText(MainActivity.this, "Orange is selected", Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(MainActivity.this, "Orange is unselected", Toast.LENGTH_SHORT).show();

                    }
                });
        check3.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        if(((CheckBox)v).isChecked()){
                            Toast.makeText(MainActivity.this, "Grapes is selected", Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(MainActivity.this, "Grapes is unselected", Toast.LENGTH_SHORT).show();

                    }
                });
    }

    public void selectItem(View view){
        boolean checked = ((CheckBox)view).isChecked();
            switch (view.getId()){
                case R.id.fruit_apple:
                    if (checked) {
                        selection.add("Tom");
                    }else{
                        selection.remove("Tom");
                    }
                    break;
                case R.id.fruit_orange:
                    if (checked) {
                        selection.add("Orange");
                    }else{
                        selection.remove("Orange");
                    }
                    break;
                case R.id.fruit_grapes:
                    if (checked) {
                        selection.add("Grapes");
                    }else{
                        selection.remove("Grapes");
                    }
                    break;

            }
    }

    public void finalSelection(View view){
        String final_fruit_selection = "";
        for(String Selections : selection){
            final_fruit_selection = final_fruit_selection + Selections + "\n";
        }
        final_text.setText(final_fruit_selection);
        final_text.setEnabled(true);
    }
}
