package com.lanou.xuhaijia.enjoylife.travel.collection;/*
                   _ooOoo_
                  o8888888o
                  88" . "88
                  (| -_- |)
                  O\  =  /O
               ____/`---'\____
             .'  \\|     |//  `.
            /  \\|||  :  |||//  \
           /  _||||| -:- |||||-  \
           |   | \\\  -  /// |   |
           | \_|  ''\---/''  |   |
           \  .-\__  `-`  ___/-. /
         ___`. .'  /--.--\  `. . __
      ."" '<  `.___\_<|>_/___.'  >'"".
     | | :  ` - `.;`\ _ /`;.`/ - ` : | |
     \  \ `-.   \_ __\ /__ _/   .-` /  /
======`-.____`-.___\_____/___.-`____.-'======
                   `=---='
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
            佛祖保佑       永无BUG
/**
 * Created by 常久青 on 16/9/27.
 */

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class CollectionAttractBean {
    public static final String TAG = "TAG_CollectionAttractBean";

    @Id(autoincrement = true)
    private Long id;
    private String nameCN;
    private String urlPic;
    private String nameUser ;
    private String urlAtt ;

    public String getUrlAtt() {
        return urlAtt;
    }

    public void setUrlAtt(String urlAtt) {
        this.urlAtt = urlAtt;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    @Generated(hash = 807614430)
    public CollectionAttractBean(Long id, String nameCN, String urlPic,
            String nameUser, String urlAtt) {
        this.id = id;
        this.nameCN = nameCN;
        this.urlPic = urlPic;
        this.nameUser = nameUser;
        this.urlAtt = urlAtt;
    }

    @Generated(hash = 2074509048)
    public CollectionAttractBean() {
    }

 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCN() {
        return nameCN;
    }

    public void setNameCN(String nameCN) {
        this.nameCN = nameCN;
    }

    public String getUrlPic() {
        return urlPic;
    }

    public void setUrlPic(String urlPic) {
        this.urlPic = urlPic;
    }
}
