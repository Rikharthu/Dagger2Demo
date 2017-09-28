package com.example.uberv.dagger2demo.di.components;

import com.example.uberv.dagger2demo.screens.SecondActivity;
import com.example.uberv.dagger2demo.di.annotations.PerActivity;
import com.example.uberv.dagger2demo.di.modules.BaseActivityModule;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import timber.log.Timber;

@PerActivity
@Subcomponent(
        modules = SecondActivityComponent.SecondActivityModule.class
)
public interface SecondActivityComponent {

    SecondActivity inject(SecondActivity activity);

    @Module
    public static class SecondActivityModule extends BaseActivityModule<SecondActivity> {

        public SecondActivityModule(SecondActivity activity) {
            super(activity);
        }

        @Provides
        @Named("second_activity")
        @PerActivity
        String provideIndexString() {
            Timber.d("Providing index string");
            return "Second";
        }
    }
}
