package com.lanou.xuhaijia.enjoylife.myself;

import java.util.List;

/**
 * Created by 徐海佳 on 16/10/8.
 */
public class DayEnglishBean {

    /**
     * sid : 2365
     * tts : http://news.iciba.com/admin/tts/2016-10-08-day.mp3
     * content : Even miracles take a little time. —The Fairy Godmother
     * note : 就算是奇迹也要花点时间才能发生的。 —仙女教母
     * love : 1628
     * translation : 词霸小编：小时候看灰姑娘的时候真的是好喜欢这个故事。长大后小编就一直在琢磨，水晶鞋真的不合脚有木有~要不然怎么会跑着跑着跑掉了呢？
     * picture : http://cdn.iciba.com/news/word/20161008.jpg
     * picture2 : http://cdn.iciba.com/news/word/big_20161008b.jpg
     * caption : 词霸每日一句
     * dateline : 2016-10-08
     * s_pv : 7
     * sp_pv : 0
     * tags : [{"id":"10","name":"正能量"},{"id":"33","name":"人生感悟"}]
     * fenxiang_img : http://cdn.iciba.com/web/news/longweibo/imag/2016-10-08.jpg
     */

    private String sid;
    private String tts;
    private String content;
    private String note;
    private String love;
    private String translation;
    private String picture;
    private String picture2;
    private String caption;
    private String dateline;
    private String s_pv;
    private String sp_pv;
    private String fenxiang_img;
    /**
     * id : 10
     * name : 正能量
     */

    private List<TagsBean> tags;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getTts() {
        return tts;
    }

    public void setTts(String tts) {
        this.tts = tts;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getLove() {
        return love;
    }

    public void setLove(String love) {
        this.love = love;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPicture2() {
        return picture2;
    }

    public void setPicture2(String picture2) {
        this.picture2 = picture2;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getDateline() {
        return dateline;
    }

    public void setDateline(String dateline) {
        this.dateline = dateline;
    }

    public String getS_pv() {
        return s_pv;
    }

    public void setS_pv(String s_pv) {
        this.s_pv = s_pv;
    }

    public String getSp_pv() {
        return sp_pv;
    }

    public void setSp_pv(String sp_pv) {
        this.sp_pv = sp_pv;
    }

    public String getFenxiang_img() {
        return fenxiang_img;
    }

    public void setFenxiang_img(String fenxiang_img) {
        this.fenxiang_img = fenxiang_img;
    }

    public List<TagsBean> getTags() {
        return tags;
    }

    public void setTags(List<TagsBean> tags) {
        this.tags = tags;
    }

    public static class TagsBean {
        private String id;
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
