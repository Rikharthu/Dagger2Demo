package com.example.uberv.dagger2demo.screens;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.uberv.dagger2demo.R;

import javax.inject.Inject;
import javax.inject.Named;

public class GreetingActivity extends AppCompatActivity {

    @Inject
    @Named("greeting")
    String mGreeting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting);
    }
}
