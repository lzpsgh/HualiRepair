package com.lzp.hualirepair.tools;
import android.util.Log;

import com.lzp.hualirepair.BuildConfig;

/**
 * Created by 镜界 on 2015/9/22 0022.
 * 9:30更新--自动生成调用类tag和调用方法
 * 另外如果真的能在release时自动屏蔽log就可以把int常量都删了
 *--
 * Log.a方法跟Log.v一样要手动添加Log
 */
public class LogUtil {

    static String className;
    static String methodName;
    static int lineNumber;
    public static final int VERBOSE =1;
    public static final int DEBUG =2;
    public static final int INFO =3;
    public static final int WARN =4;
    public static final int ERROR =5;
    public static final int NOTHING =6;
    public static final int LEVEL =VERBOSE;

    public static boolean isDebuggable() {
        return BuildConfig.DEBUG;
    }

    private static String createLog( String log ) {

        StringBuffer buffer = new StringBuffer();
        buffer.append("[");
        buffer.append(methodName);
        buffer.append(":");
        buffer.append(lineNumber);
        buffer.append("]");
        buffer.append(log);

        return buffer.toString();
    }

    private static void getMethodNames(StackTraceElement[] sElements){
        className = sElements[1].getFileName();
        methodName = sElements[1].getMethodName();
        lineNumber = sElements[1].getLineNumber();
    }

    public static void e(String message){
        if (!isDebuggable())
            return;

        // Throwable instance must be created before any methods
        getMethodNames(new Throwable().getStackTrace());
        Log.e(className, createLog(message));
    }

    public static void i(String message){
        if (!isDebuggable())
            return;

        getMethodNames(new Throwable().getStackTrace());
        Log.i(className, createLog(message));
    }

    public static void d(String message){
        if (!isDebuggable())
            return;

        getMethodNames(new Throwable().getStackTrace());
        Log.d(className, createLog(message));
    }

    public static void v(String message){
        if (!isDebuggable())
            return;

        getMethodNames(new Throwable().getStackTrace());
        Log.v(className, createLog(message));
    }

    public static void w(String message){
        if (!isDebuggable())
            return;

        getMethodNames(new Throwable().getStackTrace());
        Log.w(className, createLog(message));
    }

    public static void wtf(String message){
        if (!isDebuggable())
            return;

        getMethodNames(new Throwable().getStackTrace());
        Log.wtf(className, createLog(message));
    }

    public static void a(String tag,String message){
        if (!isDebuggable())
            return;
        Log.e(tag, message);
    }

    private LogUtil(){
        /* Protect from instantiations */
    }
//    public static void v(String tag,String msg){
//        if(LEVEL<=VERBOSE){
//            Log.v(tag, msg);
//        }
//    }
//    public static void d(String tag,String msg){
//        if(LEVEL<=DEBUG){
//            Log.d(tag, msg);
//        }
//    }
//    public static void i(String tag,String msg){
//        if(LEVEL<=INFO){
//            Log.i(tag, msg);
//        }
//    }
//    public static void w(String tag,String msg){
//        if(LEVEL<=WARN){
//            Log.w(tag,msg);
//        }
//    }
//    public static void e(String tag,String msg){
//        if(LEVEL<=ERROR){
//            Log.e(tag,msg);
//        }
//    }
}
