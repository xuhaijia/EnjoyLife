package com.lanou.xuhaijia.enjoylife.myself;

import android.app.AlertDialog;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseFragment;
import com.lanou.xuhaijia.enjoylife.base.NetTool;
import com.lanou.xuhaijia.enjoylife.myself.mugglereply.MuggleReplyAty;
import com.lanou.xuhaijia.enjoylife.tools.Blur;

import java.io.File;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by 徐海佳 on 16/9/13.
 */
public class MyselfFragment extends BaseFragment implements View.OnClickListener {
    private ImageView background;
    private FrameLayout frameLayout;
    private LinearLayout set;
    private BmobUser bmobUser;
    private CircleImageView myPhoto;
    private Bitmap bitmap;
    private TextView userName;
    private LinearLayout myCollect;
    private MyBmobUser myBmobUser;
    private TextView login;
    private CircleImageView photoLogin;
    private String url = "http://open.iciba.com/dsapi/";
    private View succeedView;
    private View failedView;
    private LinearLayout muggleReply;
    private TextView dayEnglish;

    @Override
    protected int setLayout() {
        return R.layout.fragment_myself;
    }

    @Override
    protected void initView() {
        set = bindView(R.id.fragment_myself_set);
        set.setOnClickListener(this);
        frameLayout = bindView(R.id.fragment_replace_id);
        myCollect = bindView(R.id.fragment_myself_collect);
        muggleReply = bindView(R.id.fragment_myself_reply);
        dayEnglish = bindView(R.id.fragment_myself_dayenglish);
        muggleReply.setOnClickListener(this);
        myCollect.setOnClickListener(this);
        succeedView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_succeed,null);
        failedView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_failed_no,null);
        myPhoto = (CircleImageView) succeedView.findViewById(R.id.fragment_myself_myphoto_1);
        userName = (TextView) succeedView.findViewById(R.id.fragment_myself_username_1);
        background = (ImageView) succeedView.findViewById(R.id.fragment_suddeed_background);
        login = (TextView) failedView.findViewById(R.id.fragment_login_denglu);
        photoLogin = (CircleImageView) failedView.findViewById(R.id.fragment_myself_myphoto_2);
        myPhoto.setOnClickListener(this);
        login.setOnClickListener(this);

    }

    @Override
    public void onResume() {
        super.onResume();
        myBmobUser = BmobUser.getCurrentUser(MyBmobUser.class);
        bmobUser = BmobUser.getCurrentUser();
        if (bmobUser != null){
            //登录
            frameLayout.removeAllViews();
            frameLayout.addView(succeedView);
            userName.setText(bmobUser.getUsername());
            if (myBmobUser.getIcon() == null){
                myPhoto.setImageResource(R.mipmap.ic_myself_userphoto);
                background.setVisibility(View.GONE);
            }else {
                myPhoto.setImageBitmap(myBmobUser.getIcon());
                Bitmap blurBitmap = Blur.apply(mContext,myBmobUser.getIcon(),3);
                background.setVisibility(View.VISIBLE);
                background.setImageBitmap(blurBitmap);
            }
        }else {
            //没登录
            frameLayout.removeAllViews();
            frameLayout.addView(failedView);
        }
    }

    @Override
    protected void initData() {
        mNetTool.getData(url, DayEnglishBean.class, new NetTool.NetInterface<DayEnglishBean>() {
            @Override
            public void onSuccess(DayEnglishBean dayEnglishBean) {
                dayEnglish.setText(dayEnglishBean.getContent() + "\n \n " + dayEnglishBean.getNote());
            }

            @Override
            public void onError(String errorMsg) {

            }
        });






    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fragment_myself_myphoto_1:
                showSetUserPhoto();
                break;
            case R.id.fragment_login_denglu:
                Intent  loginIntent = new Intent(getContext(),LoginActivity.class);
                startActivity(loginIntent);
                break;
            case R.id.fragment_myself_collect:
                if (myBmobUser != null) {
                    Intent intent = new Intent(getContext(), MyCollectActivity.class);
                    startActivity(intent);
                } else {
                    Intent intentLogin = new Intent(getContext() , LoginActivity.class);
                    startActivity(intentLogin);
                }
                break;
            case R.id.fragment_myself_outlogin:
                showOutDailog();
                break;
            case R.id.fragment_myself_set:
                Intent intentUser = new Intent(getContext(),UserSendActivty.class);
                startActivity(intentUser);
                break;
            case R.id.fragment_myself_reply:
                if(myBmobUser != null) {
                    Intent replyIntent = new Intent(getContext(), MuggleReplyAty.class);
                    startActivity(replyIntent);
                } else {
                    Intent intentLogin = new Intent(getContext() , LoginActivity.class);
                    startActivity(intentLogin);
                }
                break;
        }
    }


    private void showSetUserPhoto() {
        AlertDialog.Builder builder =  new AlertDialog.Builder(getContext());
        final AlertDialog dialogPhoto = builder.create();
        View view = View.inflate(getContext(), R.layout.myself_dialog_show, null);
        TextView cream = (TextView) view.findViewById(R.id.cream);
        TextView bendixiangce = (TextView) view.findViewById(R.id.bendi);

        // 在相册中选取
        bendixiangce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Intent.ACTION_PICK, null);
                intent1.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");

                startActivityForResult(intent1, 1);
                dialogPhoto.dismiss();
            }
        });
        // 调用照相机
        cream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intent2.putExtra(MediaStore.EXTRA_OUTPUT,
                        Uri.fromFile(new File(Environment.getExternalStorageDirectory(), "head.jpg")));
                startActivityForResult(intent2, 2);// 采用ForResult打开
                dialogPhoto.dismiss();
            }
        });
        dialogPhoto.setView(view);  
        dialogPhoto.show();

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {


        switch (requestCode){
            case 1:
                cropPhoto(data.getData());
                break;
            case 2:
                File file = new File(Environment.getExternalStorageDirectory() + "/head.jpg");
                cropPhoto(Uri.fromFile(file));
                break;
            case 3:
                Bundle bundle = data.getExtras();
                bitmap = bundle.getParcelable("data");
                myPhoto.setImageBitmap(bitmap);
                MyBmobUser myBmobUsers = new BmobUser().getCurrentUser(MyBmobUser.class);
                if (myBmobUsers != null){
                    myBmobUsers.setIcon(bitmap);
                    final ProgressDialog progressDialog = new ProgressDialog(getContext());
                    progressDialog.setCancelable(true);
                    progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    progressDialog.show();

                    View view = LayoutInflater.from(mContext).inflate(R.layout.activity_progress,null);
                    progressDialog.setContentView(view);


                    myBmobUsers.update(new UpdateListener() {
                        @Override
                        public void done(BmobException e) {
                            if (e == null){
                                Toast.makeText(mContext, "头像上传成功", Toast.LENGTH_SHORT).show();
                                myPhoto.setImageBitmap(bitmap);
                                Bitmap blurBitmap = Blur.apply(mContext, bitmap ,3);
                                background.setVisibility(View.VISIBLE);
                                background.setImageBitmap(blurBitmap);
                                progressDialog.dismiss();
                            }else {
                                Log.d("MyselfFragment", e.getMessage());
                                Toast.makeText(mContext, "头像上传失败", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }
                        }
                    });
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
        } catch (NullPointerException n) {

        }
    }

    public void cropPhoto(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 150);
        intent.putExtra("outputY", 150);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, 3);
    }
    private void showOutDailog(){

    }


}
