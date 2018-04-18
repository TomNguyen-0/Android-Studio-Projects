package com.example.saveafileinternalstorage;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText)findViewById(R.id.edit_text);
        textView = (TextView)findViewById(R.id.text_view);
        textView.setVisibility(View.GONE);
    }

 public void writeExternalStorage(View view)
 {
     String state;
     state = Environment.getExternalStorageState();
     Toast.makeText(getApplicationContext(),state,Toast.LENGTH_SHORT).show();
     if(Environment.MEDIA_MOUNTED.equals(state))
     {

         File Root = Environment.getExternalStorageDirectory(); //this will return the root of the external storage.
         File Dir = new File(Root.getAbsolutePath()+"/MyAppFile"); //this will create a new file inside the external storage.
         if (!Dir.exists())//if the file is not in existence this will create it.
         {
             Dir.mkdir();
         }
         File file = new File (Dir,"MyMessage.txt");
         String Message = editText.getText().toString();
         try {

             FileOutputStream fileOutputStream = new FileOutputStream(file);
             fileOutputStream.write(Message.getBytes());
             fileOutputStream.close();
             editText.setText("");
             Toast.makeText(getApplicationContext(),"Message saved",Toast.LENGTH_SHORT).show();
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }

     }
     else
     {
         Toast.makeText(getApplicationContext(),"SD card Not Found",Toast.LENGTH_LONG).show();
     }

 }

    public void readExternalStorage(View view)
    {
        File Root = Environment.getExternalStorageDirectory();
        File Dir = new File(Root.getAbsolutePath()+"/MyAppFile");
        File file = new File(Dir,"MyMessage.txt");
        String Message;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();
            while ((Message = bufferedReader.readLine())!=null)
            {
                stringBuffer.append(Message + "\n");
            }

            textView.setText(stringBuffer.toString());
            textView.setVisibility(View.VISIBLE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
