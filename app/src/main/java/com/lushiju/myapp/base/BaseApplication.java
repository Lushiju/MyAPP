package com.lushiju.myapp.base;

import android.app.Application;

import com.zhy.autolayout.config.AutoLayoutConifg;

/**
 * Created by Administrator on 2017/4/1.
 */

public class BaseApplication extends Application {

    private static BaseApplication ins = null;

    @Override
    public void onCreate() {
        super.onCreate();
        ins = this;
        AutoLayoutConifg.getInstance().useDeviceSize();
    }

    public static BaseApplication getInstance(){
        return ins;
    }
}
