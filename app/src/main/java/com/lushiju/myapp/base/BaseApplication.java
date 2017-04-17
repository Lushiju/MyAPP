package com.lushiju.myapp.base;

import android.app.Application;

import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;
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
        init();
    }

    private void init() {
        EMOptions options = new EMOptions();
        // 默认添加好友时，是不需要验证的，改成需要验证
        options.setAcceptInvitationAlways(false);
        //初始化
        EMClient.getInstance().init(this, options);
        //在做打包混淆时，关闭debug模式，避免消耗不必要的资源
        EMClient.getInstance().setDebugMode(true);
    }

    public static BaseApplication getInstance(){
        return ins;
    }
}
