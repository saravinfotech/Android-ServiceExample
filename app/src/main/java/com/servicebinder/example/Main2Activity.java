package com.servicebinder.example;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import example.com.androidserviceexample.R;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{

    BinderServiceSample customService;
    Button objButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        objButton = (Button)findViewById(R.id.timeButton);
        objButton.setOnClickListener(this);
        Intent i = new Intent(this, BinderServiceSample.class);
        bindService(i, objServiceConnection, Context.BIND_AUTO_CREATE);
    }

    public void displayTime(){
        TextView objTextView = (TextView)findViewById(R.id.timeText);
        objTextView.setText(customService.getTime());
    }

    ServiceConnection objServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            BinderServiceSample.MyServiceBinder objMyServiceBinder = (BinderServiceSample.MyServiceBinder)iBinder;
            customService = objMyServiceBinder.getServiceObject();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    public void onClick(View view) {
        if(view == objButton)
            displayTime();
    }
}
