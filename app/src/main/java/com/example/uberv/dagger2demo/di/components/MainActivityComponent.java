package com.example.uberv.dagger2demo.di.components;

import com.example.uberv.dagger2demo.screens.GreetingActivity;
import com.example.uberv.dagger2demo.di.annotations.PerActivity;
import com.example.uberv.dagger2demo.di.modules.MainActivityModule;

import dagger.Component;

@PerActivity
@Component(modules = MainActivityModule.class)
public interface MainActivityComponent {
    void inject(GreetingActivity mainActivity);
}
