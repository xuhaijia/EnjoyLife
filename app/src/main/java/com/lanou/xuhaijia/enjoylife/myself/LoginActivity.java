package com.lanou.xuhaijia.enjoylife.myself;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseActivity;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by 国冰冰 on 16/9/22.
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private EditText userName;
    private EditText passWord;
    private TextView register;
    private ImageView login;
    private ImageView imageView;

    private ProgressDialog progressDialog;
    private AnimationDrawable animationDrawable;
    private View views;

    @Override
    protected int setLayout() {
        return R.layout.activity_myself_login;
    }

    @Override
    protected void initView() {

        userName = bindView(R.id.activity_login_username);
        passWord = bindView(R.id.activity_login_password);
        register = bindView(R.id.activity_login_register);
        login = bindView(R.id.activity_login_my);
        register.setOnClickListener(this);
        login.setOnClickListener(this);


//        ProgressDialog progressDialog =new ProgressDialog(this);
//        progressDialog.setCancelable(true);
//        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);


    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.activity_login_register:
                Intent registerIntent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(registerIntent);
                finish();
                break;
            case R.id.activity_login_my:
                progressDialog = new ProgressDialog(this);
                progressDialog.setCancelable(true);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.show();
                views = LayoutInflater.from(this).inflate(R.layout.fragment_my_prograss,null);
                imageView = (ImageView) views.findViewById(R.id.fragment_login_progress);
                animationDrawable = (AnimationDrawable) imageView.getBackground();
                animationDrawable.start();
                progressDialog.setContentView(views);
                final MyBmobUser myBmobUser = new MyBmobUser();
                myBmobUser.setUsername(userName.getText().toString());
                myBmobUser.setPassword(passWord.getText().toString());
                myBmobUser.login(new SaveListener<BmobUser>() {
                    @Override
                    public void done(BmobUser bmobUser, BmobException e) {
                        if (e == null){
                            Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                            finish();
                        }else {
                            progressDialog.dismiss();
                            Toast.makeText(LoginActivity.this, "密码或用户名错误 重新输入", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                break;
        }

    }
}
