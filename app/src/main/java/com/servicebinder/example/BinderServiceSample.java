package com.servicebinder.example;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class BinderServiceSample extends Service {

    private IBinder objIBinder = new MyServiceBinder();

    public BinderServiceSample() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return objIBinder;
    }


    public String getTime(){
        SimpleDateFormat objSimpleDateFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        return objSimpleDateFormat.format(new Date());
    }

    public class MyServiceBinder extends Binder{
        BinderServiceSample getServiceObject(){
            return BinderServiceSample.this;
        }
    }
}
