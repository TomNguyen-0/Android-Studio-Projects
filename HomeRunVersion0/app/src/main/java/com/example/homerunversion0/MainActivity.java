package com.example.homerunversion0;

//import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

//public class MainActivity extends AppCompatActivity {
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void button_enter(View view){
        String button_text;
        button_text = ((Button)view).getText().toString();
        if (button_text.equals("Enter"))
        {
            Intent intent = new Intent(this, EnterActivity.class);
            startActivity(intent);
        }
        else
        {
            finish();
            System.exit(0);
        }
    }
}
