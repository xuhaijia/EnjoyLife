package com.lanou.xuhaijia.enjoylife.music.hotmusician;

import java.util.List;

/**
 * Created by 徐海佳 on 16/9/17.
 */
public class HotMusicianBean {

    /**
     * picture : https://img3.doubanio.com/view/site/median/public/085079fffda375f.jpg
     * style : 流派: 电子 Electronica
     * added : no
     * name : Wanderlust
     * rank : 1
     * member : 成员:
     * follower : 1610
     * type : artist
     * id : 102061
     */

    private List<ArtistsBean> artists;

    public List<ArtistsBean> getArtists() {
        return artists;
    }

    public void setArtists(List<ArtistsBean> artists) {
        this.artists = artists;
    }

    public static class ArtistsBean {
        private String picture;
        private String style;
        private String added;
        private String name;
        private int rank;
        private String member;
        private int follower;
        private String type;
        private String id;

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

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
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
    }
}
