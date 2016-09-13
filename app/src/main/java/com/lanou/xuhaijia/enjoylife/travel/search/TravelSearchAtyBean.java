package com.lanou.xuhaijia.enjoylife.travel.search;/*
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
 * Created by 常久青 on 16/9/13.
 */

import java.util.List;

public class TravelSearchAtyBean {
    public static final String TAG = "TAG_TravelSearchAtyBean";


    /**
     * ret : 1
     * list : [{"name":"Singapore","name_cn":"新加坡","lat":"1.2930599451065063","lng":"103.85600280761719","cityId":"0","countryId":"32244","module":"city","recordId":"32253","cover":"","parent":"Singapore,新加坡","cityName":"Singapore"},{"name":"Singapore","name_cn":"新加坡","lat":"","lng":"","cityId":"","countryId":"","module":"country","recordId":"32244","cover":"","parent":"","cityName":false},{"name":"Universal Studios - Singapore","name_cn":"新加坡环球影城","lat":"1.255443","lng":"103.8223","cityId":"32253","countryId":"32244","module":"attraction","recordId":"212216","cover":"","parent":"新加坡,新加坡","cityName":"新加坡"},{"name":"Singapore Zoo","name_cn":"新加坡动物园","lat":"1.40435","lng":"103.793","cityId":"32253","countryId":"32244","module":"attraction","recordId":"165145","cover":"","parent":"新加坡,新加坡","cityName":"新加坡"},{"name":"Singapore Flyer","name_cn":"新加坡摩天观景轮","lat":"1.289477","lng":"103.86292","cityId":"32253","countryId":"32244","module":"attraction","recordId":"165155","cover":"","parent":"新加坡,新加坡","cityName":"新加坡"},{"name":"Singapore Botanic Gardens","name_cn":"新加坡植物园","lat":"1.311808","lng":"103.81672","cityId":"32253","countryId":"32244","module":"attraction","recordId":"165140","cover":"","parent":"新加坡,新加坡","cityName":"新加坡"},{"name":"Gardens By The Bay","name_cn":"滨海湾花园","lat":"1.28157","lng":"103.864","cityId":"32253","countryId":"32244","module":"attraction","recordId":"165144","cover":"","parent":"新加坡,新加坡","cityName":"新加坡"},{"name":"Singapore Cable Car","name_cn":"新加坡缆车","lat":"1.264156","lng":"103.81928","cityId":"32253","countryId":"32244","module":"attraction","recordId":"165352","cover":"","parent":"新加坡,新加坡","cityName":"新加坡"},{"name":"National Museum of Singapore","name_cn":"新加坡国家博物馆","lat":"1.296719","lng":"103.84879","cityId":"32253","countryId":"32244","module":"attraction","recordId":"165170","cover":"","parent":"新加坡,新加坡","cityName":"新加坡"},{"name":"Adventure Cove Waterpark","name_cn":"新加坡水上探险乐园","lat":"1.249404","lng":"103.83032","cityId":"32253","countryId":"32244","module":"attraction","recordId":"165222","cover":"","parent":"新加坡,新加坡","cityName":"新加坡"},{"name":"Singapore River","name_cn":"新加坡河","lat":"1.288331","lng":"103.85625","cityId":"32253","countryId":"32244","module":"attraction","recordId":"165195","cover":"","parent":"新加坡,新加坡","cityName":"新加坡"},{"name":"National Orchid Garden","name_cn":"国家兰花园","lat":"1.31298","lng":"103.814","cityId":"32253","countryId":"32244","module":"attraction","recordId":"165138","cover":"","parent":"新加坡,新加坡","cityName":"新加坡"},{"name":"Merlion Park","name_cn":"狮头鱼尾像","lat":"1.286915","lng":"103.85452","cityId":"32253","countryId":"32244","module":"attraction","recordId":"165190","cover":"","parent":"新加坡,新加坡","cityName":"新加坡"},{"name":"Flight Experience Flight Simulator","name_cn":"新加坡飞行体验","lat":"1.295803","lng":"103.85957","cityId":"32253","countryId":"32244","module":"attraction","recordId":"165141","cover":"","parent":"新加坡,新加坡","cityName":"新加坡"},{"name":"Science Centre Singapore","name_cn":"新加坡科学中心","lat":"1.333288","lng":"103.73629","cityId":"32253","countryId":"32244","module":"attraction","recordId":"165193","cover":"","parent":"新加坡,新加坡","cityName":"新加坡"},{"name":"Marina Bay Sands Skypark","name_cn":"滨海湾沙石赌场","lat":"1.285392","lng":"103.86085","cityId":"32253","countryId":"32244","module":"attraction","recordId":"165159","cover":"","parent":"新加坡,新加坡","cityName":"新加坡"},{"name":"Marina Bay","name_cn":"滨海湾","lat":"1.28898","lng":"103.85717","cityId":"32253","countryId":"32244","module":"attraction","recordId":"165147","cover":"","parent":"新加坡,新加坡","cityName":"新加坡"},{"name":"Singapore Art Museum","name_cn":"新加坡美术馆","lat":"1.297517","lng":"103.851","cityId":"32253","countryId":"32244","module":"attraction","recordId":"165223","cover":"","parent":"新加坡,新加坡","cityName":"新加坡"},{"name":"Night Safari of Singapore","name_cn":"新加坡夜间野生动物园","lat":"1.403739","lng":"103.787285","cityId":"32253","countryId":"32244","module":"attraction","recordId":"212361","cover":"","parent":"新加坡,新加坡","cityName":"新加坡"},{"name":"Orchard Road","name_cn":"乌节路","lat":"1.30143","lng":"103.83842","cityId":"32253","countryId":"32244","module":"attraction","recordId":"165176","cover":"","parent":"新加坡,新加坡","cityName":"新加坡"}]
     */

    private int ret;
    /**
     * name : Singapore
     * name_cn : 新加坡
     * lat : 1.2930599451065063
     * lng : 103.85600280761719
     * cityId : 0
     * countryId : 32244
     * module : city
     * recordId : 32253
     * cover :
     * parent : Singapore,新加坡
     * cityName : Singapore
     */

    private List<ListBean> list;

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        private String name;
        private String name_cn;
        private String lat;
        private String lng;
        private String cityId;
        private String countryId;
        private String module;
        private String recordId;
        private String cover;
        private String parent;
        private String cityName;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName_cn() {
            return name_cn;
        }

        public void setName_cn(String name_cn) {
            this.name_cn = name_cn;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }

        public String getCityId() {
            return cityId;
        }

        public void setCityId(String cityId) {
            this.cityId = cityId;
        }

        public String getCountryId() {
            return countryId;
        }

        public void setCountryId(String countryId) {
            this.countryId = countryId;
        }

        public String getModule() {
            return module;
        }

        public void setModule(String module) {
            this.module = module;
        }

        public String getRecordId() {
            return recordId;
        }

        public void setRecordId(String recordId) {
            this.recordId = recordId;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getParent() {
            return parent;
        }

        public void setParent(String parent) {
            this.parent = parent;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }
    }
}
