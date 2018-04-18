package com.example.createastartservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by tom on 7/28/2016.
 */
public class MyBoundService extends Service {

    private  final IBinder mBinder = new LocalService();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    public class LocalService extends Binder
    {

        MyBoundService getService()
        {
            return MyBoundService.this;
        }
    }

    public String getFirstMessage()
    {
        return "Hello World!";
    }

    public String getSecondMessage()
    {
        return "This is Bound Service Example . . .";
    }
}
