package com.example.interprocessmessenger;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.Nullable;

/**
 * Created by tom on 7/31/2016.
 */
public class MyService extends Service {

    private final int JOB_1=1, JOB_2=2, JOB_1_RESPONSE = 3, JOB_2_RESPONSE = 4;
    Messenger messenger = new Messenger(new IncomingHandler());

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return messenger.getBinder();
    }

    class IncomingHandler extends Handler
    {
        @Override
        public void handleMessage(Message msg) {

            Message MSG;
            String message;
            Bundle bundle = new Bundle();
            switch(msg.what)
            {
                case JOB_1:
                    message = "This is the First Message from Service...";
                    MSG = Message.obtain(null,JOB_1_RESPONSE);
                    bundle.putString("response_message",message);
                    MSG.setData(bundle);
                    try {
                        msg.replyTo.send(MSG);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    break;
                case JOB_2:
                    message = "This is the Second Message from Service...";
                    MSG = Message.obtain(null,JOB_2_RESPONSE);
                    bundle.putString("response_message",message);
                    MSG.setData(bundle);
                    try {
                        msg.replyTo.send(MSG);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    super.handleMessage(msg);
            }
        }
    }
}
