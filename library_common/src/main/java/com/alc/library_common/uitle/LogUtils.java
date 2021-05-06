package com.alc.library_common.uitle;

import android.util.Log;

import com.alc.library_common.BuildConfig;


/**
 * Created by lwb on 2017/12/25.
 * 日志封装
 */

public class LogUtils {
    static String className;//类名
    static String methodName;//方法名
    static int lineNumber;//行数

    /**
     * 判断是否可以调试
     *
     * @return
     */
    public static boolean isDebuggable() {
        return BuildConfig.DEBUG;
    }

    private static String createLog(String log) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("==").append(methodName);
        buffer.append("(").append(className).append(":").append(lineNumber).append(")==:");
       // buffer.append(stackTraceElementString());
        buffer.append(log);


        return buffer.toString();
    }
    private static String stackTraceElementString(){
        StackTraceElement[] list = Thread.currentThread().getStackTrace();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (list.length > 3) {
            sb.append(list[3].getFileName() + "#" + list[3].getMethodName() + "(" + list[3].getLineNumber() + ")_");
        }
        if (list.length > 4) {
            sb.append(list[4].getFileName() + "#" + list[4].getMethodName() + "(" + list[4].getLineNumber() + ")_");
        }
        if (list.length > 5) {
            sb.append(list[5].getFileName() + "#" + list[5].getMethodName() + "(" + list[5].getLineNumber() + ")");
        }
        sb.append("]");
        return sb.toString();
    }
    /**
     * 获取文件名、方法名、所在行数
     *
     * @param sElements
     */
    private static void getMethodNames(StackTraceElement[] sElements) {
        className = sElements[1].getFileName();
        methodName = sElements[1].getMethodName();
        lineNumber = sElements[1].getLineNumber();
    }

    public static void e(String message) {
        if (!isDebuggable())
            return;
        getMethodNames(new Throwable().getStackTrace());
        Log.e(className, createLog(message));
    }

    public static void i(String message) {
        if (!isDebuggable())
            return;
        getMethodNames(new Throwable().getStackTrace());
        Log.i(className,createLog(message));
    }
    public static void i(String tag,String message) {
        if (!isDebuggable())
            return;
        getMethodNames(new Throwable().getStackTrace());
        Log.i(tag,className+createLog(message));
    }

    public static void d(String message) {
        if (!isDebuggable())
            return;
        getMethodNames(new Throwable().getStackTrace());
        Log.d(className, createLog(message));
    }

    public static void v(String message) {
        if (!isDebuggable())
            return;
        getMethodNames(new Throwable().getStackTrace());
        Log.v(className, createLog(message));
    }

    public static void w(String message) {
        if (!isDebuggable())
            return;
        getMethodNames(new Throwable().getStackTrace());
        Log.w(className, createLog(message));
    }

}