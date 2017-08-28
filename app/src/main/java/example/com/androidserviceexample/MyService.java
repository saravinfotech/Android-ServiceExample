package example.com.androidserviceexample;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;

/**
 * Created by Saravanan on 8/28/2017.
 */

public class MyService extends Service {

    MediaPlayer objMediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        objMediaPlayer = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
        objMediaPlayer.setLooping(true);
        objMediaPlayer.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        objMediaPlayer.stop();
    }
}
