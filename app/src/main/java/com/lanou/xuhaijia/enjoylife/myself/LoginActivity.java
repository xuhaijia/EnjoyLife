package com.lanou.xuhaijia.enjoylife.myself;

import android.content.Intent;
import android.util.Log;
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
    private LinearLayout login;

    @Override
    protected int setLayout() {
        return R.layout.activity_myself_login;
    }

    @Override
    protected void initView() {
        userName = bindView(R.id.activity_login_username);
        passWord = bindView(R.id.activity_login_password);
        register = bindView(R.id.activity_login_register);
        login = bindView(R.id.activity_login_ing);
        register.setOnClickListener(this);
        login.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.activity_login_register:
                Log.d("LoginActivity", "her -----");
                Intent registerIntent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(registerIntent);
                finish();
                break;
            case R.id.activity_login_ing:
                final MyBmobUser myBmobUser = new MyBmobUser();
                myBmobUser.setUsername(userName.getText().toString());
                myBmobUser.setPassword(passWord.getText().toString());
                myBmobUser.login(new SaveListener<BmobUser>() {
                    @Override
                    public void done(BmobUser bmobUser, BmobException e) {
                        if (e == null){
                            Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                            finish();
                        }else {
                            Log.d("LoginActivity" + "失败  原因", e.toString());
                            Toast.makeText(LoginActivity.this, "密码或用户名错误 重新输入", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                break;
        }

    }
}
