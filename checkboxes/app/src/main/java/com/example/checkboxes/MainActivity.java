package com.example.checkboxes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CheckBox check1,check2,check3;
    private Button button_sel;
    private View v2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
        addListenerToCheckBox();
    }

    public void addListenerToCheckBox(){
        check1 = (CheckBox)findViewById(R.id.checkBox);
        check2 = (CheckBox)findViewById(R.id.checkBox2);
        check3 = (CheckBox)findViewById(R.id.checkBox3);
        check1.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        if(((CheckBox)v).isChecked()){
                            Toast.makeText(MainActivity.this, "Dog is selected", Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(MainActivity.this, "Dog is unselected", Toast.LENGTH_SHORT).show();

                    }
                });
        check2.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        if(((CheckBox)v).isChecked()){
                            Toast.makeText(MainActivity.this, "Cat is selected", Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(MainActivity.this, "Cat is unselected", Toast.LENGTH_SHORT).show();

                    }
                });
        check3.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        if(((CheckBox)v).isChecked()){
                            Toast.makeText(MainActivity.this, "Cow is selected", Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(MainActivity.this, "Cow is unselected", Toast.LENGTH_SHORT).show();

                    }
                });
    }

    public void addListenerOnButton(){
        check1 = (CheckBox)findViewById(R.id.checkBox);
        check2 = (CheckBox)findViewById(R.id.checkBox2);
        check3 = (CheckBox)findViewById(R.id.checkBox3);
        button_sel = (Button)findViewById(R.id.button);

        button_sel.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                StringBuffer result = new StringBuffer();
                result.append("Dog : ").append(check1.isChecked());
                result.append("\nCat : ").append(check2.isChecked());
                result.append("\nCow : ").append(check3.isChecked());
                Toast.makeText(MainActivity.this, result.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
