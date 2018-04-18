package com.example.boundservicemessenger;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by tom on 7/28/2016.
 */
public class MyService extends Service {

    static  final int JOB_1 = 1;
    static  final int JOB_2 = 2;
    Messenger mMessenger = new Messenger(new InComingHandler());

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(getApplicationContext(),"Service Binding . . .",Toast.LENGTH_SHORT).show();
        return mMessenger.getBinder();
    }

    class InComingHandler extends Handler
    {
        @Override
        public void handleMessage(Message msg) {

            switch (msg.what)
            {
                case JOB_1:
                    Toast.makeText(getApplicationContext(),"Hello from Job 1",Toast.LENGTH_SHORT).show();
                    break;
                case JOB_2:
                    Toast.makeText(getApplicationContext(),"Hello from Job 2",Toast.LENGTH_SHORT).show();
                    break;
                default:
                    super.handleMessage(msg);
            }

        }
    }
}
