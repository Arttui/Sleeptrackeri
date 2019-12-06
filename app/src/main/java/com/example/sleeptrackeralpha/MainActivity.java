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
        sharedPreferences = getSharedPreferences("SaveData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("aika", "Time slept:  " + ajastin.getText().toString());
        editor.putString("paiva" ,"Date:  " + juttu.getText().toString());
        editor.apply();
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
}





