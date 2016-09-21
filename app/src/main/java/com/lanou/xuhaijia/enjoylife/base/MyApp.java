package com.lanou.xuhaijia.enjoylife.base;
//                .-~~~~~~~~~-._       _.-~~~~~~~~~-.
//            __.'              ~.   .~              `.__
//          .'//                  \./                   \\`.
//        .'//            为什么坚持  想一想当初             \\`.
//      .'// .-~"""""""~~~~-._     |     _,-~~~~"""""""~-.  \\`.
//    .'//.-"                 `-.  |  .-'                 "-. \\`.
//  .'//______.============-..   \ | /   ..-============._______\\`.
//.'//____________________________\|/_____________________________\\`.
// 
//                             

import android.app.Application;
import android.content.Context;
import android.os.Build;

import com.baidu.mapapi.SDKInitializer;

import java.io.File;
import java.io.FileFilter;



/**
 * Created by 徐海佳 on 16/9/12.
 * App
 */
public class MyApp extends Application {

    // !!!别忘记注册
    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        SDKInitializer.initialize(this);

    }

    public static Context getContext() {
        return mContext;
    }


    public static int getNumberOfCPUCores() {
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.GINGERBREAD_MR1) {
            // Gingerbread doesn't support giving a single application access to both cores, but a
            // handful of devices (Atrix 4G and Droid X2 for example) were released with a dual-core
            // chipset and Gingerbread; that can let an app in the background run without impacting
            // the foreground application. But for our purposes, it makes them single core.
            return 1;
        }
        int cores;
        try {
            cores = new File("/sys/devices/system/cpu/").listFiles(CPU_FILTER).length;
        } catch (SecurityException e) {
            cores = 0;
        } catch (NullPointerException e) {
            cores = 0;
        }
        return cores;
    }
    private static final FileFilter CPU_FILTER = new FileFilter() {
        @Override
        public boolean accept(File pathname) {
            String path = pathname.getName();
            //regex is slow, so checking char by char.
            if (path.startsWith("cpu")) {
                for (int i = 3; i < path.length(); i++) {
                    if (path.charAt(i) < '0' || path.charAt(i) > '9') {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
    };
}
