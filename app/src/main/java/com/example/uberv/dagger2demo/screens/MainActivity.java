package com.example.uberv.dagger2demo.screens;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.uberv.dagger2demo.App;
import com.example.uberv.dagger2demo.R;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.OkHttpClient;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    @Inject
    @Named("cached")
    OkHttpClient mCachedOkHttpClient;
    @Inject
    @Named("non_cached")
    OkHttpClient mOkHttpClient;
    @Inject
    SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        App.get(this).getNetComponent().inject(this);

        Timber.d("MainActivity creation finished");
    }

    @OnClick(R.id.second_activity_btn)
    void onGoToSecondActivity() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.third_activity_btn)
    void onGoToThirdActivity() {
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.github_activity_btn)
    void onGoToGithubActivity() {
        Intent intent = new Intent(this, GithubActivity.class);
        startActivity(intent);
    }
}
