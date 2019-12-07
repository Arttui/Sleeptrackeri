package com.example.sleeptrackeralpha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextClock;


public class MainActivity extends AppCompatActivity {

    public Chronometer ajastin;
    public TextClock juttu;
    private long pauseOffset;
    private boolean kaynnissa;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ajastin = findViewById(R.id.kello);
        ajastin.setBase(SystemClock.elapsedRealtime());
        juttu = this.findViewById(R.id.juttu);
    }

    public void startti(View v) {

        //Jos ajastin on jo käynnissä "startti" ei tee mitään
        if (!kaynnissa) {

            //Käynnistää ajastimen
            ajastin.setBase(SystemClock.elapsedRealtime() - pauseOffset);
            ajastin.start();
            kaynnissa = true;
        }
    }

    public void resetti(View v) {

        //Asettaa arvot SharedPreferenssiin
        sharedPreferences = getSharedPreferences("SaveData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("aika", "Time slept:  " + ajastin.getText().toString());
        editor.putString("paiva" ,"Date:  " + juttu.getText().toString());
        editor.apply();

        //Sammuttaa ajastimen
        ajastin.setBase(SystemClock.elapsedRealtime());
        ajastin.stop();
        pauseOffset = 0;
        kaynnissa = false;

        //Käynnistää Ratingbar aktiviteetin
        Intent unenlaatu = new Intent(getBaseContext(), Ratingbar.class);
        startActivity(unenlaatu);
    }

    //Käynnistää SleepData aktiviteetin
    public void historia(View v){
        Intent historia = new Intent(getBaseContext(), SleepData.class);
        startActivity(historia);
    }
}





