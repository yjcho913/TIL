package edu.android20191112.myapplication;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
    MediaPlayer player;

    public MyService() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "Service onCreate...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service onStartCommand...", Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, "Service : " + intent.getStringExtra("url"), Toast.LENGTH_SHORT).show();
        Log.i("INFO", "나의 정체는 : " + Thread.currentThread().getName());

        if(player != null) {
            player.stop();
            player.release();
        }
        player = MediaPlayer.create(this, R.raw.aa);
        player.setLooping(false);
        player.start();

        // START_STICKY           : 비정상적으로 죽어도, 다시 살아남 (onStartCommand가 자동 호출)
        // START_NOT_STICKY       : 비정상적으로 죽으면, 끝
        // START_REDELIVER_INTENT : 비정상적으로 죽으면, 이전 intent로 onStartCommand가 자동 호출
        // return super.onStartCommand(intent, flags, startId);
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service onDestroy...", Toast.LENGTH_SHORT).show();

        if(player != null) {
            player.stop();
            player.release();
            player = null;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
