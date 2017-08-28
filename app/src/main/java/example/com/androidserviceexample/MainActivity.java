package example.com.androidserviceexample;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button startButton, stopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = (Button)findViewById(R.id.startMusic);
        startButton.setOnClickListener(this);
        stopButton = (Button)findViewById(R.id.stopMusice);
        stopButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == startButton)
        {
            startService(new Intent(MainActivity.this,MyService.class));
        }else{
            stopService(new Intent(MainActivity.this,MyService.class));
        }
    }
}
