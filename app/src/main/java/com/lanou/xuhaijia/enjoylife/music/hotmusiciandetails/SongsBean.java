package com.lanou.xuhaijia.enjoylife.music.hotmusiciandetails;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 徐海佳 on 16/9/19.
 */
public class SongsBean {

    /**
     * picture : https://img1.doubanio.com/view/site/median/public/e8b2a1cc7e81407.jpg
     * playlist : [{"id":"191657525","title":"「我是个年轻人我心情不太好」 "},{"id":"189992733","title":"「P&amp;G&amp; I *Demo」"},{"id":"189964782","title":"「我愚蠢的理想主义」"},{"id":"14891341","title":"「更新中」"},{"id":"18784888","title":"「Drama Q」夏诞特献"},{"id":"18399468","title":"「复杂世界」春诞特献"},{"id":"5926591","title":"「她的右脑」demo"},{"id":"14457317","title":"「预谋邂逅」"},{"id":"190050657","title":"「中文歌最屌，英文当调料」"},{"id":"190050640","title":"「到此一游」城市特辑"}]
     * added : yes
     * name : 放肆的肆
     * style : 流派: 流行 Pop
     * member : 成员:
     * follower : 95521
     * type : artist
     * id : 101781
     */

    private String picture;
    private String added;
    private String name;
    private String style;
    private String member;
    private int follower;
    private String type;
    private String id;
    /**
     * id : 191657525
     * title : 「我是个年轻人我心情不太好」
     */

    private List<PlaylistBean> playlist;
    /**
     * title : 今晚演出很牛逼，不信你去打听打听！
     * url : https://www.douban.com/event/27159949/
     * abstract : 7月18日 周一 － 7月22日 周五 长沙
     * month : 7
     * day : 18
     * icon : https://img1.doubanio.com/view/event_poster/small/public/e265e2691e7764b.jpg
     */

    private List<EventsBean> events;
    /**
     * cover : https://img3.doubanio.com/view/photo/albumicon/public/p2182025983.jpg
     * id : 16690388
     * title : 行 走
     */

    private List<AlbumsBean> albums;
    /**
     * content : 来呀 互相伤害啊
     * author : 初心不忘.
     * time : 09-12 17:34
     * icon : https://img1.doubanio.com/icon/user_normal.jpg
     */

    private List<MessagesBean> messages;

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
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

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<PlaylistBean> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(List<PlaylistBean> playlist) {
        this.playlist = playlist;
    }

    public List<EventsBean> getEvents() {
        return events;
    }

    public void setEvents(List<EventsBean> events) {
        this.events = events;
    }

    public List<AlbumsBean> getAlbums() {
        return albums;
    }

    public void setAlbums(List<AlbumsBean> albums) {
        this.albums = albums;
    }

    public List<MessagesBean> getMessages() {
        return messages;
    }

    public void setMessages(List<MessagesBean> messages) {
        this.messages = messages;
    }

    public static class PlaylistBean {
        private String id;
        private String title;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
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

    public static class AlbumsBean {
        private String cover;
        private String id;
        private String title;

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    public static class MessagesBean {
        private String content;
        private String author;
        private String time;
        private String icon;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }
}
