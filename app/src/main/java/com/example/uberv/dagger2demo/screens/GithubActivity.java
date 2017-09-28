package com.example.uberv.dagger2demo.screens;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.uberv.dagger2demo.App;
import com.example.uberv.dagger2demo.R;
import com.example.uberv.dagger2demo.di.annotations.UserScope;
import com.example.uberv.dagger2demo.di.components.DaggerGithubComponent;
import com.example.uberv.dagger2demo.di.modules.GithubModule;

import javax.inject.Inject;

public class GithubActivity extends AppCompatActivity {

    @UserScope
    @Inject
    GithubModule.GitHubApiInterface mGithuApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github);

        DaggerGithubComponent.builder()
                .netComponent(App.get(this).getNetComponent())
                .build().inject(this);
    }
}
