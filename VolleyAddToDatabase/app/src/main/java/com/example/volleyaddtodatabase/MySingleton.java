package com.example.volleyaddtodatabase;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by tom on 9/1/2016.
 */
public class MySingleton {

    private static MySingleton mySingleton;
    private RequestQueue requestQueue;
    private static Context context;

    private MySingleton(Context context)
    {
        this.context = context;
        requestQueue = getRequestQueue();
    }

    public static synchronized MySingleton getMySingleton(Context context)
    {
        if(mySingleton == null)
        {
            mySingleton = new MySingleton(context);
        }
        return mySingleton;
    }

    public RequestQueue getRequestQueue()
    {
        if (requestQueue == null)
        {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }

    public<T> void addToRequestque(Request<T> request)
    {
        requestQueue.add(request);
    }

}
