package com.lanou.xuhaijia.enjoylife.music.typesearch;

import java.util.List;

/**
 * Created by 徐海佳 on 16/9/19.
 */
public class TypeSearchBean {

    /**
     * q : 我
     * total : 15
     * genrelist : [["6","流行"],["8","摇滚"],["3","电子"],["4","民谣"],["5","爵士"],["2","轻音乐"],["1","古典"],["10","世界音乐"],["7","说唱"],["9","原声"],["11","实验"]]
     * tags : [{"url":"Alternative","name":"Alternative","size":1},{"url":"Ambient","name":"Ambient","size":1},{"url":"Blues","name":"Blues","size":1},{"url":"Electronica","name":"Electronica","size":1},{"url":"Folk","name":"Folk","size":2},{"url":"Funk","name":"Funk","size":1},{"url":"Hardcore","name":"Hardcore","size":1},{"url":"Hip-Hop","name":"Hip-Hop","size":2},{"url":"Hiphop","name":"Hiphop","size":2},{"url":"Indie","name":"Indie","size":3},{"url":"Jazz","name":"Jazz","size":2},{"url":"Metal","name":"Metal","size":2},{"url":"Pop","name":"Pop","size":4},{"url":"Punk","name":"Punk","size":2},{"url":"R%26B","name":"R&amp;B","size":2},{"url":"Rap","name":"Rap","size":3},{"url":"Rock","name":"Rock","size":3},{"url":"%E7%94%B5%E5%AD%90","name":"电子","size":2},{"url":"%E7%8B%AC%E7%AB%8B","name":"独立","size":2},{"url":"%E5%8F%A4%E5%85%B8","name":"古典","size":1},{"url":"%E9%87%91%E5%B1%9E","name":"金属","size":1},{"url":"%E7%88%B5%E5%A3%AB","name":"爵士","size":2},{"url":"%E6%B5%81%E8%A1%8C","name":"流行","size":4},{"url":"%E6%B5%81%E8%A1%8C%E6%91%87%E6%BB%9A","name":"流行摇滚","size":1},{"url":"%E6%B0%91%E8%B0%A3","name":"民谣","size":4},{"url":"%E6%9C%8B%E5%85%8B","name":"朋克","size":1},{"url":"%E5%AE%9E%E9%AA%8C","name":"实验","size":1},{"url":"%E8%AF%B4%E5%94%B1","name":"说唱","size":2},{"url":"%E6%91%87%E6%BB%9A","name":"摇滚","size":3},{"url":"%E7%A1%AC%E6%A0%B8","name":"硬核","size":1}]
     * artists : [{"member":"成员: ","picture":"https://img3.doubanio.com/view/site/median/public/926be27b60b778e.jpg","style":"流派: 民谣 Folk","added":"no","name":"我真的不知道","follower":65,"type":"artist","id":"103138"},{"member":"成员: ","picture":"https://img3.doubanio.com/view/site/median/public/e5d02f4b5165c4d.jpg","style":"流派: 摇滚 Rock","added":"no","name":"我希望遍体鳞伤","follower":45,"type":"artist","id":"114475"},{"member":"成员: ","picture":"https://img3.doubanio.com/view/site/median/public/d4aabc979695111.jpg","style":"流派: 摇滚 Rock","added":"no","name":"My Bad Day(我糟糕的一天）","follower":21,"type":"artist","id":"104832"},{"member":"成员: ","picture":"https://img3.doubanio.com/view/site/median/public/2bf95651e6f2e74.jpg","style":"流派: 流行 Pop","added":"no","name":"『我乐歌喵』","follower":10,"type":"artist","id":"215919"},{"member":"成员: ","picture":"https://img3.doubanio.com/view/site/median/public/37f26848957e36d.jpg","style":"流派: 民谣 Folk","added":"no","name":"我弟弟的游戏","follower":7,"type":"artist","id":"136736"},{"member":"成员: ","picture":"https://img3.doubanio.com/view/site/median/public/259d1dc480f0b51.jpg","style":"流派: 摇滚 Rock","added":"no","name":"我只是想在这里放一些我自己的东西。","follower":7,"type":"artist","id":"245260"},{"member":"成员: ","picture":"https://img1.doubanio.com/view/site/median/public/3e4302231e96ffc.jpg","style":"流派: 民谣 Folk","added":"no","name":"允许我丑陋","follower":5,"type":"artist","id":"173880"},{"member":"成员: ","picture":"https://img3.doubanio.com/view/site/median/public/45ee6505cc2f35e.jpg","style":"风格: 朗读 民谣  古琴 诗歌 童话 故事","added":"no","name":"【Story&amp;Voice】陌生人，我愿意为你朗读 ","follower":5,"type":"dj","id":"245281"},{"member":"成员: ","picture":"https://img3.doubanio.com/view/site/median/public/94a4b196db28b32.jpg","style":"风格: 经典老歌","added":"no","name":"我就是大强","follower":2,"type":"dj","id":"231081"},{"member":"成员: ","picture":"https://img3.doubanio.com/view/site/median/public/6c92c988791bf5f.jpg","style":"流派: 流行 Pop","added":"no","name":"我zm","follower":1,"type":"artist","id":"140843"},{"member":"成员: ","picture":"https://img1.doubanio.com/view/site/median/public/bbba773946049aa.jpg","style":"流派: 世界音乐 World","added":"no","name":"束缚我","follower":1,"type":"artist","id":"263649"},{"member":"成员: ","picture":"https://img1.doubanio.com/view/site/median/public/f33b1e47c4a6847.jpg","style":"流派: 流行 Pop","added":"no","name":"今夜我有点坏","follower":1,"type":"artist","id":"255317"},{"member":"成员: ","picture":"https://img3.doubanio.com/view/site/median/public/d62fcb3d6416f62.jpg","style":"流派: 世界音乐 World","added":"no","name":"我是花","follower":0,"type":"artist","id":"259380"},{"member":"成员: ","picture":"https://img1.doubanio.com/view/site/median/public/cab0a28fb0d636b.jpg","style":"流派: 民谣 Folk","added":"no","name":"陆婉君","follower":22,"type":"artist","id":"116143"},{"member":"成员: ","picture":"https://img3.doubanio.com/view/site/median/public/5dad8af5372417e.jpg","style":"流派: 摇滚 Rock","added":"no","name":"阿柒","follower":5,"type":"artist","id":"252033"}]
     */

    private String q;
    private int total;
    private List<List<String>> genrelist;
    /**
     * url : Alternative
     * name : Alternative
     * size : 1
     */

    private List<TagsBean> tags;
    /**
     * member : 成员:
     * picture : https://img3.doubanio.com/view/site/median/public/926be27b60b778e.jpg
     * style : 流派: 民谣 Folk
     * added : no
     * name : 我真的不知道
     * follower : 65
     * type : artist
     * id : 103138
     */

    private List<ArtistsBean> artists;

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<List<String>> getGenrelist() {
        return genrelist;
    }

    public void setGenrelist(List<List<String>> genrelist) {
        this.genrelist = genrelist;
    }

    public List<TagsBean> getTags() {
        return tags;
    }

    public void setTags(List<TagsBean> tags) {
        this.tags = tags;
    }

    public List<ArtistsBean> getArtists() {
        return artists;
    }

    public void setArtists(List<ArtistsBean> artists) {
        this.artists = artists;
    }

    public static class TagsBean {
        private String url;
        private String name;
        private int size;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }
    }

    public static class ArtistsBean {
        private String member;
        private String picture;
        private String style;
        private String added;
        private String name;
        private int follower;
        private String type;
        private String id;

        public String getMember() {
            return member;
        }

        public void setMember(String member) {
            this.member = member;
        }

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
    }
}
