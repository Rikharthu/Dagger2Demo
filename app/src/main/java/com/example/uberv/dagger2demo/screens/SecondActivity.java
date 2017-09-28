package com.example.uberv.dagger2demo.screens;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.example.uberv.dagger2demo.R;
import com.example.uberv.dagger2demo.di.components.NetComponent;
import com.example.uberv.dagger2demo.di.components.SecondActivityComponent;
import com.example.uberv.dagger2demo.di.modules.BaseActivity;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SecondActivity extends BaseActivity {

    @Inject
    @Named("second_activity")
    String mActivityName;

    @BindView(R.id.title)
    TextView mTitleTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
        mTitleTv.setText(mActivityName);
    }

    @Override
    protected void setupActivityComponent(NetComponent appComponent) {
        // instantiate a subcomponent and use it
        appComponent.plus(new SecondActivityComponent.SecondActivityModule(this)).inject(this);
    }
}
