package com.example.uberv.dagger2demo.di.components;

import com.example.uberv.dagger2demo.di.ApplicationBinders;
import com.example.uberv.dagger2demo.di.SubcomponentBuilder;
import com.example.uberv.dagger2demo.di.modules.AppModule;
import com.example.uberv.dagger2demo.di.modules.NetModule;
import com.example.uberv.dagger2demo.screens.MainActivity;

import java.util.Map;

import javax.inject.Provider;
import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules = {AppModule.class, NetModule.class, ApplicationBinders.class})
public interface NetComponent {
    void inject(MainActivity activity);

    // TODO understand how it works https://github.com/codepath/android_guides/wiki/Dependency-Injection-with-Dagger-2
    // Declare subcomponent builders:
    // Returns a map with all the builders mapped by their class.
    Map<Class<?>, Provider<SubcomponentBuilder>> subcomponentBuilders();

    // remove injection methods if downstream modules will perform injection
    // See GithubComponent
    // void inject(GithubActivity activity);

    // Subcomponents
    // factory method to instantiate the subcomponent defined here (passing in the module instance)
    SecondActivityComponent plus(SecondActivityComponent.SecondActivityModule module);

    // Dependent components need required parts to be exposed
    // in parent component
    Retrofit getRetrofit();
}
