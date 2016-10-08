package com.lanou.xuhaijia.enjoylife.myself.mugglereply.base;

/**
 * Created by 徐海佳 on 16/9/28.
 */
public interface ReplyContract {



    interface View extends BaseView {

        /**
         * 接收客户端返回的信息
         */
        void receiveMsgFromServer(String msgFromServer);
    }

    interface Presenter extends BasePresenter {

        /**
         * 设置model层
         */
        void setModel(Model model);
        /**
         * 获取将要传给客服的数据
         */
        void getQuestion(String question);

        /**
         * 获取回来数据
         * @param text
         */
        void getReply(String text);
    }

    interface Model {
        /**
         * 接收客户的信息 匹配回复的信息内容 返回
         * @param clientMsg
         * @return
         */
        void msgFromServer(String clientMsg);

    }
}
