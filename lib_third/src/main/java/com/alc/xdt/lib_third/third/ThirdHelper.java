package com.alc.xdt.lib_third.third;

import android.annotation.SuppressLint;
import android.app.Application;

import com.alc.xdt.lib_third.BuildConfig;
import com.alibaba.android.arouter.launcher.ARouter;

import cat.ereza.customactivityoncrash.CustomActivityOnCrash;
import cat.ereza.customactivityoncrash.activity.DefaultErrorActivity;
import cat.ereza.customactivityoncrash.config.CaocConfig;

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/26
 */
public class ThirdHelper {
    private static Application mApplication;
    private static volatile  ThirdHelper instance;
    private ThirdHelper() {
    }

    public static  ThirdHelper getInstance(Application application) {
        if (instance == null) {
            synchronized ( ThirdHelper.class) {
                if (instance == null) {
                    mApplication = application;
                    instance = new  ThirdHelper();
                }
            }
        }
        return instance;
    }
    public  ThirdHelper initRouter() {

        if (BuildConfig.DEBUG) {
            // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(mApplication); // 尽可能早，推荐在Application中初始化
        return this;
    }

    @SuppressLint("RestrictedApi")
    public  ThirdHelper initCrashView() {
        CaocConfig.Builder.create()
                .backgroundMode(CaocConfig.BACKGROUND_MODE_SILENT)
                .enabled(true)//这阻止了对崩溃的拦截,false表示阻止。用它来禁用customactivityoncrash框架
                .minTimeBetweenCrashesMs(2000)      //定义应用程序崩溃之间的最短时间，以确定我们不在崩溃循环中。比如：在规定的时间内再次崩溃，框架将不处理，让系统处理！
                .errorActivity(DefaultErrorActivity.class) //程序崩溃后显示的页面
                .apply();


//        CaocConfig.Builder.create()
//                .backgroundMode(CaocConfig.BACKGROUND_MODE_SILENT) //default: CaocConfig.BACKGROUND_MODE_SHOW_CUSTOM
//                .enabled(false) //default: true
//                .showErrorDetails(false) //default: true
//                .showRestartButton(false) //default: true
//                .logErrorOnRestart(false) //default: true
//                .trackActivities(true) //default: false
//                .minTimeBetweenCrashesMs(2000) //default: 3000
//                .errorDrawable(R.drawable.ic_custom_drawable) //default: bug image
//                .restartActivity(YourCustomActivity.class) //default: null (your app's launch activity)
//                .errorActivity(YourCustomErrorActivity.class) //default: null (default error activity)
//                .eventListener(new YourCustomEventListener()) //default: null
//                .apply();


        //如果没有任何配置，程序崩溃显示的是默认的设置
        CustomActivityOnCrash.install(mApplication);
        return this;
    }

}
