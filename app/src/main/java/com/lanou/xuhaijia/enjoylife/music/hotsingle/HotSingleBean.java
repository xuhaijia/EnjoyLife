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
    /**
     * name : 「我是个年轻人我心情不太好」
     * id : 191657525
     */

    private PlaylistBean playlist;
    /**
     * playlist : {"name":"「我是个年轻人我心情不太好」 ","id":"191657525"}
     * artist_id : 101781
     * artist_name : 放肆的肆
     */

    private String artist_id;
    private String artist_name;

    public List<SongsBean> getSongs() {
        return songs;
    }

    public void setSongs(List<SongsBean> songs) {
        this.songs = songs;
    }

    public PlaylistBean getPlaylist() {
        return playlist;
    }

    public void setPlaylist(PlaylistBean playlist) {
        this.playlist = playlist;
    }

    public String getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(String artist_id) {
        this.artist_id = artist_id;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
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

    public static class PlaylistBean {
        private String name;
        private String id;

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
    }
}
