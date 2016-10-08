package com.lanou.xuhaijia.enjoylife.myself.mugglereply;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseActivity;
import com.lanou.xuhaijia.enjoylife.myself.MyBmobUser;
import com.lanou.xuhaijia.enjoylife.myself.mugglereply.base.BasePresenter;
import com.lanou.xuhaijia.enjoylife.myself.mugglereply.base.ReplyContract;
import com.lanou.xuhaijia.enjoylife.myself.mugglereply.base.ReplyModel;
import com.lanou.xuhaijia.enjoylife.myself.mugglereply.base.ReplyPresenter;

import java.util.ArrayList;

/**
 * Created by 徐海佳 on 16/9/30.
 */
public class MuggleReplyAty extends BaseActivity implements View.OnClickListener , ReplyContract.View{

    private Button sendBtn;
    private EditText et;
    private ListView lv;
    private MuggleReplyAdapter adapter;
    private ReplyBean replyBean;
    private MyBmobUser myBmobUser;
    private ReplyContract.Presenter mPresenter;

    @Override
    protected int setLayout() {
        return R.layout.activity_mugglereply;
    }

    @Override
    protected void initView() {
        lv = bindView(R.id.activity_mugglereply_lv);
        sendBtn = bindView(R.id.activity_mugglereply_send);
        sendBtn.setOnClickListener(this);
        et = bindView(R.id.activity_mugglereply_et);
    }

    @Override
    protected void initData() {
        myBmobUser = MyBmobUser.getCurrentUser(MyBmobUser.class);
        adapter = new MuggleReplyAdapter(this);
        replyBean = new ReplyBean();
        replyBean.setContent("亲爱的 " + myBmobUser.getUsername() +" 你好,欢迎您对我们提出宝贵的意见");
        replyBean.setType(1);
        ArrayList<ReplyBean> arrayList = new ArrayList<>();
        arrayList.add(replyBean);
        adapter.setArrayList(arrayList);
        lv.setAdapter(adapter);
        ReplyPresenter replyPresenter = new ReplyPresenter(this);
        ReplyModel replyModel = new ReplyModel(replyPresenter);
        replyPresenter.setModel(replyModel);
        this.setPresenter(replyPresenter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.activity_mugglereply_send:
                if (et.getText().length() != 0) {
                    String question = et.getText().toString();
                    ReplyBean replyBean = new ReplyBean();
                    replyBean.setBitmap(myBmobUser.getIcon());
                    replyBean.setType(0);
                    replyBean.setContent(question);
                    adapter.addArrayList(replyBean);
                    mPresenter.getQuestion(question);
                    lv.setSelection(adapter.getCount());
                }
                break;
        }
    }

    /**
     * 接收客户端返回的信息
     *
     * @param msgFromServer
     */
    @Override
    public void receiveMsgFromServer(String msgFromServer) {
        ReplyBean replyBean = new ReplyBean();
        replyBean.setType(1);
        replyBean.setContent(msgFromServer);
        adapter.addArrayList(replyBean);
        lv.setSelection(adapter.getCount());
    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        mPresenter = (ReplyContract.Presenter) presenter;
    }
}
