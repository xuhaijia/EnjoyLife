package com.lanou.xuhaijia.enjoylife.myself;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseActivity;
import com.lanou.xuhaijia.enjoylife.tools.Blur;

import cn.bmob.v3.BmobUser;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by 国冰冰 on 16/9/27.
 */
public class UserSendActivty extends BaseActivity implements View.OnClickListener {
    private FrameLayout frameLayout;
    private TextView sendUserName;
    private ImageView backgroud;
    private ImageView InternetImg;
    private ImageView back;
    private LinearLayout linearLayout;
    private MyBmobUser myBmobUser;
    private BmobUser bmobUser;
    private View loginYes;
    private View loginNo;
    private CircleImageView imageView;

    @Override
    protected int setLayout() {
        return R.layout.activity_user_send;
    }

    @Override
    protected void initView() {
        frameLayout = bindView(R.id.activity_user_fragment_id);
        loginYes = LayoutInflater.from(this).inflate(R.layout.fragment_login_yes, null);
        loginNo = LayoutInflater.from(this).inflate(R.layout.fragment_login_no, null);
        imageView = (CircleImageView) loginYes.findViewById(R.id.activity_user_photo);
        backgroud = (ImageView) loginYes.findViewById(R.id.backgroud_yes);
        back = (ImageView) loginYes.findViewById(R.id.fragment_login_yes_back);
        sendUserName = (TextView) loginYes.findViewById(R.id.activity_user_name);
        linearLayout = (LinearLayout) loginYes.findViewById(R.id.fragment_myself_outlogin);
        InternetImg = (ImageView) loginNo.findViewById(R.id.fragment_login_on_img);
        linearLayout.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        String url = "http://img4.imgtn.bdimg.com/it/u=3284998899,4269937841&fm=21&gp=0.jpg";
        Glide.with(this).load(url).into(InternetImg);
    }

    @Override
    public void onResume() {
        super.onResume();
        myBmobUser = BmobUser.getCurrentUser(MyBmobUser.class);
        bmobUser = BmobUser.getCurrentUser();
        if (bmobUser != null) {
            frameLayout.removeAllViews();
            frameLayout.addView(loginYes);
            sendUserName.setText(bmobUser.getUsername());
            if (myBmobUser.getIcon() != null) {
                imageView.setImageBitmap(myBmobUser.getIcon());
//                Bitmap blurBitmap = Blur.apply(this, myBmobUser.getIcon(), 7);
//                backgroud.setImageBitmap(blurBitmap);
            }
        } else {
            frameLayout.removeAllViews();
            frameLayout.addView(loginNo);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fragment_login_yes_back:
                finish();
                break;
            case R.id.fragment_myself_outlogin:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("是否退出当前账号?  无法享受用户福利哦!")
                        .setIcon(android.R.drawable.ic_dialog_info)
                        .setPositiveButton("是,我不要享受", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                BmobUser.logOut();
                                BmobUser current = BmobUser.getCurrentUser();
                                finish();
                            }
                        })
                        .setNegativeButton("我还有点舍不得", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(UserSendActivty.this, "亲爱的用户谢谢您的支持哦", Toast.LENGTH_SHORT).show();
                            }
                        }).show();
                break;
        }


    }

}
