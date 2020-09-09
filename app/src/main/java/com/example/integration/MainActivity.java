package com.example.integration;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Appodeal.initialize(this, "590a524b2c1842b81da4fa868f8c229bee170199e8e95428", adTypes, consentValue);
    }
}