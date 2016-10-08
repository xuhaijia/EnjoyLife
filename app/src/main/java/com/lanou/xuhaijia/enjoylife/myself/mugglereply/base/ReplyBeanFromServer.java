package com.lanou.xuhaijia.enjoylife.myself.mugglereply.base;

/**
 * Created by 徐海佳 on 16/9/30.
 */
public class ReplyBeanFromServer {

    /**
     * code : 100000
     * text : 鞍山到太原您可以在沈阳北站中转 鞍山到沈阳北站乘坐4287次 鞍山站13.37开 14.55到达沈阳北站 硬座票价8元 然后换乘1140次沈阳北站17.25开
     */

    private int code;
    private String text;
    /**
     * url : http://touch.qunar.com/h5/train/trainList?startStation=%E5%A4%A7%E8%BF%9E&endStation=%E6%B2%88%E9%98%B3&searchType=stasta&date=2016-10-09&sort=3&filterTrainType=1&filterTrainType=2&filterTrainType=3&filterTrainType=4&filterTrainType=5&filterTrainType=6&filterTrainType=7&filterDeptTimeRange=1&filterDeptTimeRange=2&filterDeptTimeRange=3&filterDeptTimeRange=4
     */

    private String url;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
