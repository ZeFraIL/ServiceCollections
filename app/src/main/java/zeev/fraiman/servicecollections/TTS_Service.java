package zeev.fraiman.servicecollections;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.speech.tts.TextToSpeech;
import android.widget.Toast;

import java.util.Locale;

public class TTS_Service extends Service {

    //Thread thread;
    TextToSpeech textToSpeech;
    String st="";
    int speech, lang;

    public TTS_Service() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        st=intent.getStringExtra("text");
        Toast.makeText(this, st, Toast.LENGTH_SHORT).show();
        textToSpeech=new TextToSpeech(getApplicationContext(),
                new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if (status==TextToSpeech.SUCCESS)  {
                            Locale locale=Locale.getDefault();
                            lang=textToSpeech.setLanguage(locale);
                            speech=textToSpeech.speak(st, TextToSpeech.QUEUE_ADD,null,null);
                        }
                    }
                });
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        textToSpeech.shutdown();
    }
}

                            /*
                            thread=new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    speech=textToSpeech.speak(st, TextToSpeech.QUEUE_FLUSH,null,null);
                                }
                            });
                            thread.start();
                            */