package com.example.uberv.dagger2demo.di.modules;

import android.app.Application;
import android.content.Context;

import com.example.uberv.dagger2demo.di.annotations.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import timber.log.Timber;

@Module
public class AppModule {

    private Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        Timber.d("providing Application");
        return mApplication;
    }

    @Provides
    @Singleton
    @ApplicationContext
    Context provideAppContext() {
        Timber.d("providing Context (Application)");
        return mApplication;
    }
}
