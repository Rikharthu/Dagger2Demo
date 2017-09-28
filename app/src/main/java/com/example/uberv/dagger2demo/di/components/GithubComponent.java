package com.example.uberv.dagger2demo.di.components;

import com.example.uberv.dagger2demo.screens.GithubActivity;
import com.example.uberv.dagger2demo.di.annotations.UserScope;
import com.example.uberv.dagger2demo.di.modules.GithubModule;

import dagger.Component;

@UserScope
@Component(dependencies = NetComponent.class, modules = GithubModule.class)
public interface GithubComponent {
    void inject(GithubActivity activity);
}
