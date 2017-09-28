package com.example.uberv.dagger2demo;

import android.app.Application;
import android.content.Context;

import com.example.uberv.dagger2demo.di.components.DaggerNetComponent;
import com.example.uberv.dagger2demo.di.components.NetComponent;
import com.example.uberv.dagger2demo.di.modules.AppModule;
import com.example.uberv.dagger2demo.di.modules.NetModule;

import timber.log.Timber;

public class App extends Application {

    private NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());

        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("https://api.github.com"))
                .build();
    }

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }
}
