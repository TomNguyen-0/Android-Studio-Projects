package com.example.createastartservice;

import android.app.IntentService;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by tom on 7/28/2016.
 */
public class MyIntentService extends IntentService{

    public MyIntentService(){
        super("My_Worker_Thread");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this,"Service Started . . .",Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"Service Stopped . . .",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        synchronized (this)
        {
            int count = 0;
            while (count<10)
            {
                try {
                    wait(1500);
                    count++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
