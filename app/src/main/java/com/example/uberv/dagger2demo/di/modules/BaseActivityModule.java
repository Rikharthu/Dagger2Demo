package com.example.uberv.dagger2demo.di.modules;

import com.example.uberv.dagger2demo.di.annotations.PerActivity;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class BaseActivityModule<T extends BaseActivity> {
    protected final T mActivity;

    public BaseActivityModule(T activity) {
        mActivity = activity;
    }

    @Provides
    @PerActivity
    public T provideActivity() {
        return mActivity;
    }
}
