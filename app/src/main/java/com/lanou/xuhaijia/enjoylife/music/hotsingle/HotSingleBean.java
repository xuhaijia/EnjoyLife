package com.lanou.xuhaijia.enjoylife.music.hotsingle;

import java.util.List;

/**
 * Created by 徐海佳 on 16/9/14.
 */
public class HotSingleBean {

    /**
     * count : 4188
     * picture : https://img1.doubanio.com/view/site/median/public/e8b2a1cc7e81407.jpg
     * name : Kick Ur Ass
     * artist : 放肆的肆
     * rank : 1
     * id : 672920
     * length : 2:33
     * artist_id : 101781
     * src : http://mr3.doubanio.com/6ea3a3b94e3cf888501990d881ae852b/0/fm/song/p2659189_128k.mp3
     * widget_id : 189964782
     */

    private List<SongsBean> songs;

    public List<SongsBean> getSongs() {
        return songs;
    }

    public void setSongs(List<SongsBean> songs) {
        this.songs = songs;
    }

    public static class SongsBean {
        private int count;
        private String picture;
        private String name;
        private String artist;
        private int rank;
        private String id;
        private String length;
        private String artist_id;
        private String src;
        private String widget_id;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getArtist() {
            return artist;
        }

        public void setArtist(String artist) {
            this.artist = artist;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLength() {
            return length;
        }

        public void setLength(String length) {
            this.length = length;
        }

        public String getArtist_id() {
            return artist_id;
        }

        public void setArtist_id(String artist_id) {
            this.artist_id = artist_id;
        }

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }

        public String getWidget_id() {
            return widget_id;
        }

        public void setWidget_id(String widget_id) {
            this.widget_id = widget_id;
        }
    }
}
