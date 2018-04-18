package com.example.boundservicemessenger;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Messenger mMessenger = null;
    boolean isBind = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void bindService(View view)
    {
        Intent intent = new Intent(this,MyService.class);
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            mMessenger = new Messenger(iBinder);
            isBind = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            mMessenger = null;//if the system crash or if the system stops it
            isBind = false;
        }
    };

    public void sayHello(View view)
    {
        if(isBind) {
            String button_text;
            button_text = (String) ((Button) view).getText();
            if (button_text.equals("Say Hello")) {
                Message message = Message.obtain(null,MyService.JOB_1,0,0,0);
                try {
                    mMessenger.send(message);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            } else if (button_text.equals("Say Hello Again")) {
                Message message = Message.obtain(null,MyService.JOB_2,0,0,0);
                try {
                    mMessenger.send(message);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Bind Service First",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onStop() {
        unbindService(mConnection);
        isBind = false;
        mMessenger = null;
        super.onStop();
    }
}
