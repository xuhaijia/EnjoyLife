package com.lanou.xuhaijia.enjoylife.myself;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import cn.bmob.v3.BmobUser;

/**
 * Created by 国冰冰 on 16/9/22.
 */
public class MyBmobUser extends BmobUser {
    private byte[] icon;//用户头像

    public void setIcon(Bitmap bitmap) {
        //1 一个数组的输出流 我们之后会把图片 输出到该输出流里
        //并从该输出流里读取byte[]
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        //将图片输出的方法
        //第一个参数 是输出格式
        //     品质
        //  输出流
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        //从输出流里拿到输出的数组 为icon 赋值
        icon = byteArrayOutputStream.toByteArray();
        try {
            //关闭 输出流
            byteArrayOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Bitmap getIcon() {
        if (icon != null) {
            Bitmap bitmap = BitmapFactory.decodeByteArray(icon, 0, icon.length);
            return bitmap;
        }
        return null;
    }
}
