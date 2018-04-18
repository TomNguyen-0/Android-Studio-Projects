package com.example.createastartservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    MyBoundService myBoundService;
    boolean isbind = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView); //for MyBoundService class
        Intent intent = new Intent (this, MyBoundService.class);
        bindService(intent,Mconnection, Context.BIND_AUTO_CREATE);
    }

    public void startService(View view)
    {
//        Intent intent = new Intent(this, MyService.class);  //MyService class;
//        startService(intent);

//        Intent intent1 = new Intent(this, MyIntentService.class);
//        startService(intent1);


        String message;
        message = myBoundService.getFirstMessage();
        textView.setText(message);
        isbind = true;
        Intent intent = new Intent(this, MyBoundService.class);
        startService(intent);

    }

    public void myBoundService(View view)
    {
        String message; //MyBoundService class;
        message = myBoundService.getSecondMessage();
        textView.setText(message);
    }

    public void stopService(View view)
    {
//        Intent intent = new Intent(this, MyService.class);
//        stopService(intent);

//        Intent intent1 = new Intent(this, MyIntentService.class); //MyIntentService class
//        stopService(intent1);

        super.onStop();
        if(isbind)
        {
            unbindService(Mconnection);
            isbind = false;
        }

    }

    private ServiceConnection Mconnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

            MyBoundService.LocalService localService = (MyBoundService.LocalService)iBinder;
            myBoundService = localService.getService();
            isbind = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            isbind=false;
        }
    };
}

//important life cycle commands:
//onStartCommand()
//onBind()
//onCreate()
//onDestroy()