package com.lanou.xuhaijia.enjoylife.myself.mugglereply.base;

/**
 * Created by 徐海佳 on 16/9/30.
 */
public class ReplyPresenter implements ReplyContract.Presenter {
    ReplyContract.View mView;
    ReplyContract.Model mModel;

    public ReplyPresenter(ReplyContract.View mView) {
        this.mView = mView;
    }


    /**
     * 设置model层
     *
     * @param model
     */
    @Override
    public void setModel(ReplyContract.Model model) {
        mModel = model;
    }

    /**
     * 获取将要传给客服的数据
     *
     * @param question
     */
    @Override
    public void getQuestion(String question) {
        mModel.msgFromServer(question);
    }

    /**
     * 获取回复
     * @param text
     */
    @Override
    public void getReply(String text) {
        mView.receiveMsgFromServer(text);
    }

    @Override
    public void start() {

    }
}
