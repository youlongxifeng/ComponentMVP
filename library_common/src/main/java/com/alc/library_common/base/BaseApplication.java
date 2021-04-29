package com.alc.library_common.base;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

import com.alc.library_common.lifecycle.ApplicationObserver;
import com.alc.xdt.lib_third.third.ThirdHelper;

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/29
 */
public class BaseApplication  extends MultiDexApplication implements ViewModelStoreOwner {
    private static BaseApplication instance;
    private ViewModelStore mAppViewModelStore;

    public static BaseApplication getInstance() {
        return instance;
    }
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        this.instance=this;
        MultiDex.install(this);
        ProcessLifecycleOwner.get().getLifecycle().addObserver(new ApplicationObserver());
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mAppViewModelStore=new ViewModelStore();
        ThirdHelper.getInstance(this)
                .initRouter()
                //  .initBugly(false)
                .initCrashView();
        //    .initUM();
    }

    @NonNull
    @Override
    public ViewModelStore getViewModelStore() {
        return mAppViewModelStore;
    }
}
