package com.lanou.xuhaijia.enjoylife.music.photoin;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 徐海佳 on 16/9/19.
 */
public class PhotoInBean implements Serializable{

    /**
     * photos : [{"upload_time":"2011-08-05","photo_id":"1146048446","url":"https://img3.doubanio.com/view/photo/albumcover/public/p1146048446.jpg","uploader_name":"放肆的肆","order":0,"desc":"photo by 跑调先生"},{"upload_time":"2011-08-01","photo_id":"1139815828","url":"https://img1.doubanio.com/view/photo/albumcover/public/p1139815828.jpg","uploader_name":"放肆的肆","order":1,"desc":"@MAO后台。photo by momo"},{"upload_time":"2011-08-01","photo_id":"1139815064","url":"https://img3.doubanio.com/view/photo/albumcover/public/p1139815064.jpg","uploader_name":"放肆的肆","order":2,"desc":"photo by momo"},{"upload_time":"2011-08-01","photo_id":"1139813802","url":"https://img3.doubanio.com/view/photo/albumcover/public/p1139813802.jpg","uploader_name":"放肆的肆","order":3,"desc":"面对空旷的场壳装腔作势地试音。photo by momo"},{"upload_time":"2011-08-01","photo_id":"1139813321","url":"https://img3.doubanio.com/view/photo/albumcover/public/p1139813321.jpg","uploader_name":"放肆的肆","order":4,"desc":"终于在新MAO留下了自己的记号。虽然有点那啥\u2026寒酸。photo by momo"},{"upload_time":"2011-08-01","photo_id":"1139812175","url":"https://img3.doubanio.com/view/photo/albumcover/public/p1139812175.jpg","uploader_name":"放肆的肆","order":5,"desc":"面对空旷的场壳装腔作势地试音。photo by momo"},{"upload_time":"2011-08-01","photo_id":"1137965519","url":"https://img1.doubanio.com/view/photo/albumcover/public/p1137965519.jpg","uploader_name":"放肆的肆","order":6,"desc":"photo by 漫漫兄"},{"upload_time":"2011-08-01","photo_id":"1137965323","url":"https://img3.doubanio.com/view/photo/albumcover/public/p1137965323.jpg","uploader_name":"放肆的肆","order":7,"desc":"photo by 漫漫兄"},{"upload_time":"2011-08-01","photo_id":"1137965100","url":"https://img3.doubanio.com/view/photo/albumcover/public/p1137965100.jpg","uploader_name":"放肆的肆","order":8,"desc":""},{"upload_time":"2011-08-01","photo_id":"1137964809","url":"https://img1.doubanio.com/view/photo/albumcover/public/p1137964809.jpg","uploader_name":"放肆的肆","order":9,"desc":"photo by Lady&amp;Bird"},{"upload_time":"2011-08-01","photo_id":"1137964741","url":"https://img3.doubanio.com/view/photo/albumcover/public/p1137964741.jpg","uploader_name":"放肆的肆","order":10,"desc":"灯光昏暗，lutehole被阴影遮住啦。photo by 漫漫兄"}]
     * artist_id : 101781
     * album_name : 2011年西瓜夏天@MAO
     * artist_name : 放肆的肆
     * album_id : 4389482
     */

    private String artist_id;
    private String album_name;
    private String artist_name;
    private String album_id;
    /**
     * upload_time : 2011-08-05
     * photo_id : 1146048446
     * url : https://img3.doubanio.com/view/photo/albumcover/public/p1146048446.jpg
     * uploader_name : 放肆的肆
     * order : 0
     * desc : photo by 跑调先生
     */

    private List<PhotosBean> photos;

    public String getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(String artist_id) {
        this.artist_id = artist_id;
    }

    public String getAlbum_name() {
        return album_name;
    }

    public void setAlbum_name(String album_name) {
        this.album_name = album_name;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public String getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(String album_id) {
        this.album_id = album_id;
    }

    public List<PhotosBean> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PhotosBean> photos) {
        this.photos = photos;
    }

    public static class PhotosBean  implements Serializable{
        private String upload_time;
        private String photo_id;
        private String url;
        private String uploader_name;
        private int order;
        private String desc;

        public String getUpload_time() {
            return upload_time;
        }

        public void setUpload_time(String upload_time) {
            this.upload_time = upload_time;
        }

        public String getPhoto_id() {
            return photo_id;
        }

        public void setPhoto_id(String photo_id) {
            this.photo_id = photo_id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUploader_name() {
            return uploader_name;
        }

        public void setUploader_name(String uploader_name) {
            this.uploader_name = uploader_name;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }
}
