package com.lanou.xuhaijia.enjoylife.myself.mugglereply.base;

import com.lanou.xuhaijia.enjoylife.base.NetTool;

/**
 * Created by 徐海佳 on 16/9/30.
 */
public class ReplyModel implements ReplyContract.Model {
    ReplyContract.Presenter mPresenter;


    public ReplyModel(ReplyContract.Presenter mPresenter) {
        this.mPresenter = mPresenter;
    }


    /**
     * 接收客户的信息 匹配回复的信息内容 返回
     *
     * @param clientMsg
     * @return
     */
    @Override
    public void msgFromServer(String clientMsg) {
        NetTool mNetTool = new NetTool();
        String url = "http://www.tuling123.com/openapi/api?info=" + clientMsg + "&key=738769324c80403eaa299d3017b15cd7";
        mNetTool.getData(url, ReplyBeanFromServer.class, new NetTool.NetInterface<ReplyBeanFromServer>() {
            @Override
            public void onSuccess(ReplyBeanFromServer replyBeanFromServer) {
                if (replyBeanFromServer.getUrl() != null) {
                    mPresenter.getReply(replyBeanFromServer.getText()  + "\n <a href='"+ replyBeanFromServer.getUrl() + "'>点击查看</a>" );
                } else {
                    mPresenter.getReply(replyBeanFromServer.getText());
                }

            }

            @Override
            public void onError(String errorMsg) {

            }
        });

    }
}
