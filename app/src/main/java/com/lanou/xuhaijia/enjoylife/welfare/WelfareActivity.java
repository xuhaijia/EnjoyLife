package com.lanou.xuhaijia.enjoylife.welfare;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseActivity;
import com.lanou.xuhaijia.enjoylife.base.NetTool;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;

/**
 * Created by 徐海佳 on 16/9/22.
 */
public class WelfareActivity extends BaseActivity {

    private ImageView iv;
    private String url;
    private Bitmap drawingCache;

    @Override
    protected int setLayout() {
        return R.layout.activity_welfare;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        iv = bindView(R.id.activity_welfare_iv);

    }

    @Override
    protected void initData() {
        Glide.with(this).load(url).into(iv);
        ViewCompat.setTransitionName(iv, "image");
        iv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                new AlertDialog.Builder(WelfareActivity.this)
                        .setMessage(getString(R.string.save_meizi))
                        .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface anInterface, int i) {
                                anInterface.dismiss();
                            }
                        })
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface anInterface, int i) {
                                anInterface.dismiss();
                                saveImage();
                            }
                        }).show();
                return true;
            }
        });
    }

    private void saveImage() {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        final File directory = new File(externalStorageDirectory, "EnjoyLife");
        if (!directory.exists())
            directory.mkdir();

        mNetTool.getBitmap(url, iv.getMeasuredHeight(), iv.getMeasuredWidth(), new NetTool.GetBitMap() {
            @Override
            public void getBitMap(Bitmap bitmap) {
                drawingCache = bitmap;
                try {
                    File file = new File(directory, new Date().getTime() + ".jpg");
                    FileOutputStream fos = new FileOutputStream(file);
                    drawingCache.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                    Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                    Uri uri = Uri.fromFile(file);
                    intent.setData(uri);
                    getApplicationContext().sendBroadcast(intent);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    Snackbar.make(getCurrentFocus(), "出错了!!!!!", Snackbar.LENGTH_SHORT).show();
                }
            }
        });

    }

}
