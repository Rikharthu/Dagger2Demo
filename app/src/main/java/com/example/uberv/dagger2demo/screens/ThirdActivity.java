package com.example.uberv.dagger2demo.screens;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.example.uberv.dagger2demo.R;
import com.example.uberv.dagger2demo.di.components.NetComponent;
import com.example.uberv.dagger2demo.di.components.ThirdActivityComponent;
import com.example.uberv.dagger2demo.di.modules.BaseActivity;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ThirdActivity extends BaseActivity {

    @Inject
    @Named("third_activity")
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
        ThirdActivityComponent.Builder builder = (ThirdActivityComponent.Builder)
                appComponent.subcomponentBuilders()
                        .get(ThirdActivityComponent.Builder.class)
                        .get();
        builder.activityModule(new ThirdActivityComponent.ThirdActivityModule(this)).build().inject(this);
    }
}
