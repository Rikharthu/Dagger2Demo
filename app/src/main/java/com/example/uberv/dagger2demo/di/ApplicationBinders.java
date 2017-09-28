package com.example.uberv.dagger2demo.di;

import com.example.uberv.dagger2demo.di.annotations.SubcomponentKey;
import com.example.uberv.dagger2demo.di.components.ThirdActivityComponent;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {ThirdActivityComponent.class})
public abstract class ApplicationBinders {
    // Provide the builder to be included in a mapping used for creating the builders.
    @Binds
    @IntoMap
    @SubcomponentKey(ThirdActivityComponent.Builder.class)
    public abstract SubcomponentBuilder myActivity(ThirdActivityComponent.Builder impl);
}
