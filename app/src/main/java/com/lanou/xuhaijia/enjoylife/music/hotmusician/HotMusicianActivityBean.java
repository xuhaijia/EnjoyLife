package com.lanou.xuhaijia.enjoylife.music.hotmusician;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 徐海佳 on 16/9/18.
 */
public class HotMusicianActivityBean {

    /**
     * picture : https://img3.doubanio.com/view/site/median/public/197604b046aae66.jpg
     * style : 流派: 民谣 Folk
     * added : no
     * name : 花粥
     * id : 146032
     * member : 成员:
     * follower : 150443
     * type : artist
     * events : [{"title":"今晚演出很牛逼，不信你去打听打听！","url":"https://www.douban.com/event/27159949/","abstract":"7月18日 周一 － 7月22日 周五 长沙","month":7,"day":18,"icon":"https://img1.doubanio.com/view/event_poster/small/public/e265e2691e7764b.jpg"}]
     */

    private String picture;
    private String style;
    private String added;
    private String name;
    private String id;
    private String member;
    private int follower;
    private String type;
    /**
     * title : 今晚演出很牛逼，不信你去打听打听！
     * url : https://www.douban.com/event/27159949/
     * abstract : 7月18日 周一 － 7月22日 周五 长沙
     * month : 7
     * day : 18
     * icon : https://img1.doubanio.com/view/event_poster/small/public/e265e2691e7764b.jpg
     */

    private List<EventsBean> events;

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getAdded() {
        return added;
    }

    public void setAdded(String added) {
        this.added = added;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public int getFollower() {
        return follower;
    }

    public void setFollower(int follower) {
        this.follower = follower;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<EventsBean> getEvents() {
        return events;
    }

    public void setEvents(List<EventsBean> events) {
        this.events = events;
    }

    public static class EventsBean {
        private String title;
        private String url;
        @SerializedName("abstract")
        private String abstractX;
        private int month;
        private int day;
        private String icon;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getAbstractX() {
            return abstractX;
        }

        public void setAbstractX(String abstractX) {
            this.abstractX = abstractX;
        }

        public int getMonth() {
            return month;
        }

        public void setMonth(int month) {
            this.month = month;
        }

        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }
}
