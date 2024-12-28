package zeev.fraiman.servicecollections;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MBG_Service extends Service {

    MediaPlayer player;

    public MBG_Service() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        player = MediaPlayer.create( this, R.raw.villalobos_small );
        player.setLooping( true );
        player.start();

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
    }


}