package com.example.uberv.dagger2demo.di.modules;

import com.example.uberv.dagger2demo.di.annotations.PerActivity;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {

    @PerActivity
    @Named("greeting")
    @Provides
    String provideGreeting() {
        return "Hello, World!";
    }
}
