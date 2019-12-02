package com.example.sleeptrackeralpha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {
    private Chronometer ajastin;
    private long pauseOffset;
    private boolean kaynnissa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ajastin = findViewById(R.id.kello);
        ajastin.setBase(SystemClock.elapsedRealtime());
    }
    //Käynnistää ajastimen
    public void startti(View v) {
        if (!kaynnissa) {
            ajastin.setBase(SystemClock.elapsedRealtime() - pauseOffset);
            ajastin.start();
            kaynnissa = true;
        }
    }
    //Sammuttaa ajastimen ja käynnistää Unenlaatu aktiviteetin
    public void resetti(View v) {
        ajastin.setBase(SystemClock.elapsedRealtime());
        ajastin.stop();
        pauseOffset = 0;
        kaynnissa = false;
        Intent unenlaatu = new Intent(getBaseContext(), Ratingbar.class);
        startActivity(unenlaatu);
    }
    //Käynnistää Historia aktiviteetin
    public void historia(View v){
        Intent historia = new Intent(getBaseContext(), SleepData.class);
        startActivity(historia);
    }

    public void Gettoday() {
        
    }
}







