package com.caesar.room.app;

import android.app.Application;

/**
 * author : yangshaopeng.
 * Description:.....
 * 2018/12/14 23:20
 * email : yangshaopeng_it@163.com
 */
public class AppApplication extends Application {

    private static AppApplication sAppApplication;

    @Override
    public void onCreate()
    {
        super.onCreate();
        sAppApplication = this;
    }

    public static AppApplication getAppLication()
    {
        return sAppApplication;
    }

}
