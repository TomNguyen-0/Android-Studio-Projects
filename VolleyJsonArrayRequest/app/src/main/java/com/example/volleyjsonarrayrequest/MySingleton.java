package com.example.volleyjsonarrayrequest;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by tom on 8/31/2016.
 */
public class MySingleton {

    private static MySingleton mySingleton;
    private RequestQueue requestQueue;
    private  static Context context;

    private MySingleton(Context context)
    {
        this.context = context;
        requestQueue = getRequestQueue();
    }

    public RequestQueue getRequestQueue()
    {
        if(requestQueue == null)
        {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }

    public static synchronized MySingleton getInstance(Context context)
    {
        if(mySingleton == null)
        {
            mySingleton = new MySingleton(context);
        }
        return mySingleton;
    }

    public<T> void addToRequestque(Request<T> request)
    {
        requestQueue.add(request);
    }
}
