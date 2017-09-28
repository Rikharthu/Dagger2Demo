package com.example.uberv.dagger2demo.di.components;

import com.example.uberv.dagger2demo.di.SubcomponentBuilder;
import com.example.uberv.dagger2demo.di.annotations.PerActivity;
import com.example.uberv.dagger2demo.di.modules.BaseActivityModule;
import com.example.uberv.dagger2demo.screens.ThirdActivity;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import timber.log.Timber;

// Using Component Builder pattern

@PerActivity
@Subcomponent(modules = ThirdActivityComponent.ThirdActivityModule.class)
public interface ThirdActivityComponent {

    ThirdActivity inject(ThirdActivity activity);

    // Provide a Builder interface that will have a method build()
    // That returns an instance of given Subcomponent
    // This builder Must be added to the parent graph later
    @Subcomponent.Builder
    interface Builder extends SubcomponentBuilder<ThirdActivityComponent> {
        Builder activityModule(ThirdActivityModule module);
        // inherited from parent:
        // ThirdActivityComponent build();
    }

    @Module
    class ThirdActivityModule extends BaseActivityModule<ThirdActivity> {

        public ThirdActivityModule(ThirdActivity activity) {
            super(activity);
        }

        @Provides
        @Named("third_activity")
        @PerActivity
        String provideIndexString() {
            Timber.d("Providing index string (3)");
            return "Third";
        }
    }
}
