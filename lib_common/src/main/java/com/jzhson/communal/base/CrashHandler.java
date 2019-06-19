package com.jzhson.communal.base;

import android.os.Looper;

import com.jzhson.communal.util.UIUtils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Created by Administrator on 2017/12/8 0008.
 */

public class CrashHandler implements Thread.UncaughtExceptionHandler {

    //系统默认的处理未捕获异常的处理器
    private Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler;

    //单例模式：（懒汉式）
    //本身实例化未捕获异常的处理器的操作就是系统在一个单独的线程中完成的，所有不涉及到
    //多线程的问题，所以使用懒汉式更好！
    private CrashHandler(){

    }

    private static CrashHandler crashHandler = null;
    public static CrashHandler getInstance(){
        if(crashHandler == null){
            crashHandler = new CrashHandler();
        }
        return crashHandler;
    }


    public void init(){
        defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        //将当前类设置为出现未捕获异常的处理器
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    private boolean flag = true;
    //一旦系统出现未捕获的异常，就会调用如下的回调方法
    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        //只能用一次
        if(!flag){
            return;
        }
        flag = false;


        new Thread(){
            public void run(){
                //prepare()和loop()之间的操作就是在主线程中执行的！
                Looper.prepare();
                UIUtils.t("出现了一个意料之外的异常，我们会记录本次异常并及时处理，您可以重启app重新操作", true, UIUtils.T_ERROR);
                Looper.loop();
            }
        }.start();
        //收集异常信息
        collectionException(ex);

        try {
            Thread.sleep(2000);
            ViewManager.getInstance().finishAllActivity();
            //结束当前的进程
            android.os.Process.killProcess(android.os.Process.myPid());
            //结束虚拟机
            System.exit(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void collectionException(Throwable ex){


        //发送给后台此异常信息
        Writer mWriter = new StringWriter();
        PrintWriter mPrintWriter  = new PrintWriter(mWriter);
        ex.printStackTrace(mPrintWriter);
        ex.printStackTrace();
        Throwable mThrowable = ex.getCause();
        while (mThrowable!=null){
            mThrowable.printStackTrace(mPrintWriter);
            mPrintWriter.append("       ");
            mThrowable = mThrowable.getCause();

        }
        mPrintWriter.close();
        final String exMessage = ex.getMessage() +"   "+ mWriter.toString();

        //发送异常信息
//        doLog(exMessage);

    }



}
