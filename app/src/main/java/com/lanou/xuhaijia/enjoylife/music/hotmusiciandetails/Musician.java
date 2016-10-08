package com.lanou.xuhaijia.enjoylife.music.hotmusiciandetails;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

import cn.bmob.v3.BmobObject;

/**
 * Created by 徐海佳 on 16/9/20.
 */
@Entity
public class Musician extends BmobObject {
    @Id(autoincrement = true)
    private Long id;
    private String name;
    private String musicianId;
    private String icon;
    private String style;
    private String member;
    private String careCount;
    private String userName;
    private Long time;

    @Generated(hash = 536676827)
    public Musician(Long id, String name, String musicianId, String icon,
            String style, String member, String careCount, String userName,
            Long time) {
        this.id = id;
        this.name = name;
        this.musicianId = musicianId;
        this.icon = icon;
        this.style = style;
        this.member = member;
        this.careCount = careCount;
        this.userName = userName;
        this.time = time;
    }

    @Generated(hash = 413182955)
    public Musician() {
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getCareCount() {
        return careCount;
    }

    public void setCareCount(String careCount) {
        this.careCount = careCount;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMusicianId() {
        return musicianId;
    }

    public void setMusicianId(String musicianId) {
        this.musicianId = musicianId;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

