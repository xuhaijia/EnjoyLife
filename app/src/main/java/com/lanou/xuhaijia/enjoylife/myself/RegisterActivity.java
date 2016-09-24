package com.lanou.xuhaijia.enjoylife.myself;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseActivity;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by 国冰冰 on 16/9/22.
 */
public class RegisterActivity  extends BaseActivity implements View.OnClickListener {
    private EditText registerName;
    private EditText registerPassWord;
    private LinearLayout registerIng;

    @Override
    protected int setLayout() {
        return R.layout.activity_refister;
    }

    @Override
    protected void initView() {
        registerIng = bindView(R.id.activity_register_ing);
        registerName = bindView(R.id.activity_register_username);
        registerPassWord = bindView(R.id.activity_register_password);
        registerIng.setOnClickListener(this);



    }

    @Override
    protected void initData() {
    }

    @Override
    public void onClick(View view) {

        BmobUser bmobUser = new BmobUser();
        bmobUser.setUsername(registerName.getText().toString());
        bmobUser.setPassword(registerPassWord.getText().toString());
        bmobUser.signUp(new SaveListener<BmobUser>() {
            @Override
            public void done(BmobUser bmobUser, BmobException e) {
                if (e == null){
                    Toast.makeText(RegisterActivity.this, "注册成功,请在此登录", Toast.LENGTH_LONG).show();
                    Intent intent  = new Intent(RegisterActivity.this,LoginActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Log.d("RegisterActivity", e.toString() + "失败");
                    Toast.makeText(RegisterActivity.this,"注册失败,用户名冲突",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
