package com.lzp.hualirepair.tools;

import android.app.Application;
import android.content.Context;

/**
 * Created by 镜界 on 2015/9/23 0023.
 */
public class MyApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();//这句有影响吗?
        context=getApplicationContext();
    }

    public static Context getContext(){
        return context;
    }

}
