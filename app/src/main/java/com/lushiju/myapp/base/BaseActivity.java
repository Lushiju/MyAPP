package com.lushiju.myapp.base;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.lushiju.myapp.utils.StatusBarCompat;
import com.zhy.autolayout.AutoLayoutActivity;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/4/1.
 */

public abstract class BaseActivity extends AutoLayoutActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        StatusBarCompat.compat(this, Color.TRANSPARENT);
        ButterKnife.bind(this);
        initAllMembersView(savedInstanceState);
    }
    public abstract int getContentViewId();
    protected abstract void initAllMembersView(Bundle savedInstanceState);

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
