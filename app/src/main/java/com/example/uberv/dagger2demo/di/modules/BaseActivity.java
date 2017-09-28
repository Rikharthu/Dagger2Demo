package com.example.uberv.dagger2demo.di.modules;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.uberv.dagger2demo.App;
import com.example.uberv.dagger2demo.di.components.NetComponent;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActivityComponent(App.get(this).getNetComponent());
    }

    protected abstract void setupActivityComponent(NetComponent appComponent);
}
