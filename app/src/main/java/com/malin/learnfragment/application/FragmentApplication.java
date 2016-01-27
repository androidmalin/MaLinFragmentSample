package com.malin.learnfragment.application;

import android.app.Application;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

/**
 * 类描述:
 * 创建人:lin.ma@renren-inc.com
 * 创建时间:16-1-27
 * 备注:{@link } Thanks for  ,Her code is very good ! I made reference to his code,It saves me a lot of time!
 * 修改人:
 * 修改时间:
 * 修改备注:
 */
public class FragmentApplication extends Application {
    private static final String TAG = FragmentApplication.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();

        Logger.init(TAG).logLevel(LogLevel.FULL);
    }
}
