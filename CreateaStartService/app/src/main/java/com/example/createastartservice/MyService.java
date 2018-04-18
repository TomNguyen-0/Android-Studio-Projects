package com.example.createastartservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

/**
 * Created by tom on 7/12/2016.
 */
    public class MyService extends Service {

    final class MyThreadClass implements Runnable
    {
        int service_id;
        MyThreadClass(int service_id)
        {
            this.service_id = service_id;
        }

        @Override
        public void run() {
            int i = 0;
            synchronized (this)
            {
                while(i < 10)
                {
                    try {
                        wait (1500);//pause for 15 seconds.
                        i++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                stopSelf(service_id);
            }
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(this,"Service Started ...",Toast.LENGTH_LONG).show();
        Thread thread = new Thread(new MyThreadClass(startId));
        thread.start();
        return START_STICKY; //this is in the system somewhere, this value.
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this,"Service Destoryed ...",Toast.LENGTH_LONG).show();
    }

    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }
}
