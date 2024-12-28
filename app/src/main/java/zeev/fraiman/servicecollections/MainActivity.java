package zeev.fraiman.servicecollections;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Context context;
    Button bStart, bStop;
    Intent forservice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context=MainActivity.this;
        initComponents();

        goSpeach("Welcome to text to speech service");

        bStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(forservice);
            }
        });

        bStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(forservice);
            }
        });

    }

    private void initComponents() {

        bStart=findViewById(R.id.bStart);
        bStop=findViewById(R.id.bStop);
        forservice=new Intent(context, MBG_Service.class);
    }

    private void goSpeach(String st)  {
        Intent goSpeachService=new Intent(context, TTS_Service.class);
        goSpeachService.putExtra("text", st);
        startService(goSpeachService);
    }

}