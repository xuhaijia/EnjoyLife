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

    /**
     * ret : 1
     * list : [{"name":"9/11 Memorial","name_cn":"9.11纪念园","lat":"40.710007","lng":"-74.013039","cityId":"19039","countryId":"5040","module":"attraction","recordId":"59155","cover":"","parent":"纽约,美国","cityName":"纽约"},{"name":"Downing Street","name_cn":"唐宁街10号","lat":"51.503353","lng":"-0.127556","cityId":"22951","countryId":"22242","module":"attraction","recordId":"93544","cover":"","parent":"伦敦,英国","cityName":"伦敦"},{"name":"GK-1 M block","name_cn":"","lat":"0","lng":"0","cityId":"22699","countryId":"22238","module":"attraction","recordId":"116787","cover":"","parent":"新德里,印度","cityName":"新德里"},{"name":"Taipei 101","name_cn":"台北101大楼","lat":"25.033428","lng":"121.564842","cityId":"32593","countryId":"32557","module":"attraction","recordId":"167431","cover":"","parent":"台北,台湾","cityName":"台北"},{"name":"17-Mile Drive","name_cn":"17哩路","lat":"36.604282","lng":"-121.95901","cityId":"9924","countryId":"5040","module":"attraction","recordId":"22916","cover":"","parent":"蒙特里,美国","cityName":"蒙特里"},{"name":"ANGER 1 ","name_cn":"","lat":"50.977351545352","lng":"11.035646611291","cityId":"23049","countryId":"22243","module":"attraction","recordId":"132861","cover":"","parent":"爱尔福特,德国","cityName":"爱尔福特"},{"name":"St. Louis Cemetery No. 1","name_cn":"圣路易斯一号墓地","lat":"29.959","lng":"-90.0712","cityId":"5520","countryId":"5040","module":"attraction","recordId":"4816","cover":"","parent":"新奥尔良,美国","cityName":"新奥尔良"},{"name":"Ground Zero Catholic Memorial","name_cn":"归零地(9.11世贸中心遗址)","lat":"40.711418","lng":"-74.01368","cityId":"19039","countryId":"5040","module":"attraction","recordId":"59205","cover":"","parent":"纽约,美国","cityName":"纽约"},{"name":"21st Century Museum of Contemporary Art","name_cn":"金泽21世纪美术馆","lat":"36.560871","lng":"136.658188","cityId":"23184","countryId":"23131","module":"attraction","recordId":"136435","cover":"","parent":"金泽,日本","cityName":"金泽"},{"name":"sky100 Hong Kong Observation Deck","name_cn":"天际100香港观景台","lat":"22.3034","lng":"114.16","cityId":"32556","countryId":"32554","module":"attraction","recordId":"176172","cover":"","parent":"香港,香港","cityName":"香港"},{"name":"Tombeau de Napoléon 1er","name_cn":"拿破仑墓","lat":"48.854893","lng":"2.312605","cityId":"22115","countryId":"22085","module":"attraction","recordId":"71756","cover":"","parent":"巴黎,法国","cityName":"巴黎"},{"name":"1","name_cn":"","lat":"0","lng":"0","cityId":"23000","countryId":"22243","module":"attraction","recordId":"130162","cover":"","parent":"罗斯托克,德国","cityName":"罗斯托克"},{"name":"Minato Mirai 21","name_cn":"未来21世纪港","lat":"35.4542617797852","lng":"139.638549804688","cityId":"23202","countryId":"23131","module":"attraction","recordId":"136702","cover":"","parent":"横滨,日本","cityName":"横滨"},{"name":"Battleship USS Iowa BB-61","name_cn":"Battleship USS Iowa BB-61","lat":"33.7423","lng":"-118.277","cityId":"9742","countryId":"5040","module":"attraction","recordId":"21359","cover":"","parent":"洛杉矶,美国","cityName":"洛杉矶"},{"name":"Hong Thien Hotel 1","name_cn":"洪天1号酒店","lat":"16.469591981973707","lng":"107.59546682238579","cityId":"31033","countryId":"30702","module":"hotel","recordId":"347193","cover":"","parent":"顺化,越南","cityName":"顺化"},{"name":"Spitalfields E1","name_cn":"","lat":"51.519496519492","lng":"-0.075561062345045","cityId":"22951","countryId":"22242","module":"attraction","recordId":"125592","cover":"","parent":"伦敦,英国","cityName":"伦敦"},{"name":"Le Jardin Albert 1er","name_cn":"阿尔伯特一世花园","lat":"43.6964","lng":"7.26881","cityId":"22164","countryId":"22085","module":"attraction","recordId":"70503","cover":"","parent":"尼斯,法国","cityName":"尼斯"},{"name":"1 Lexham Gardens","name_cn":"1莱克斯汉姆花园酒店","lat":"51.495","lng":"-0.190284","cityId":"22951","countryId":"22242","module":"hotel","recordId":"206847","cover":"","parent":"伦敦,英国","cityName":"伦敦"},{"name":"Budget 1 Hotel","name_cn":"1号经济型酒店","lat":"-37.74587877656125","lng":"145.00832498073578","cityId":"22544","countryId":"22237","module":"hotel","recordId":"228652","cover":"","parent":"墨尔本,澳大利亚","cityName":"墨尔本"},{"name":"Okay 1 Villa","name_cn":"欧卡1别墅酒店","lat":"13.3637","lng":"103.852","cityId":"24429","countryId":"23427","module":"hotel","recordId":"285069","cover":"","parent":"暹粒,柬埔寨","cityName":"暹粒"}]
     */

    private int ret;
    /**
     * name : 9/11 Memorial
     * name_cn : 9.11纪念园
     * lat : 40.710007
     * lng : -74.013039
     * cityId : 19039
     * countryId : 5040
     * module : attraction
     * recordId : 59155
     * cover :
     * parent : 纽约,美国
     * cityName : 纽约
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
