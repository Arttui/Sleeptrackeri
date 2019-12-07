package com.example.sleeptrackeralpha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;


public class SleepData extends AppCompatActivity {

    TextView arvo, arvo2, arvo3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep_data);
        arvo = this.findViewById(R.id.lopputulos);
        arvo2 = this.findViewById(R.id.lopputulos2);
        arvo3 = this.findViewById(R.id.lopputulos3);

        //Hakee arvot SharedPreferenssistä
        SharedPreferences result = getSharedPreferences("SaveData", Context.MODE_PRIVATE);
        String value = result.getString("aika", "value not found");
        String value2 = result.getString("paiva", "value not found");
        String value3 = result.getString("arvio", "value not found");

        //Asettaa arvot tekstikenttiin
        arvo.setText(value);
        arvo2.setText(value2);
        arvo3.setText(value3);
    }
}
