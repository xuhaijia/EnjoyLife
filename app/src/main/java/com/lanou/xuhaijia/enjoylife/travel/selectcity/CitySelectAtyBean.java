package com.lanou.xuhaijia.enjoylife.travel.selectcity;/*
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
 * Created by 常久青 on 16/9/18.
 */

import java.util.List;

public class CitySelectAtyBean {
    public static final String TAG = "TAG_CitySelectAtyBean";


    /**
     * ret : 1
     * continents : [{"id":"32753","type":"continent","continentId":"0","countryId":"0","name":"Asia","name_cn":"亚洲","cover":"","path":"","countrys":[{"id":"1","type":"country","continentId":"32753","countryId":"0","name":"Thailand","name_cn":"泰国","cover":"http://img.koubeilvxing.com/pics/upload/2015-07-28/55b6d992efaed.jpg@!thumb","capitalId":0},{"id":"22238","type":"country","continentId":"32753","countryId":"0","name":"India","name_cn":"印度","cover":"http://img.koubeilvxing.com/pics/upload/2014-09-30/542a6c0bae9bc.jpg@!thumb","capitalId":0},{"id":"23131","type":"country","continentId":"32753","countryId":"0","name":"Japan","name_cn":"日本","cover":"http://img.koubeilvxing.com/pics/upload/2015-05-13/55532586b131c.jpg@!thumb","capitalId":0},{"id":"23277","type":"country","continentId":"32753","countryId":"0","name":"South Korea","name_cn":"韩国","cover":"http://img.koubeilvxing.com/pics/upload/2015-05-13/55532556374ef.jpg@!thumb","capitalId":0},{"id":"23373","type":"country","continentId":"32753","countryId":"0","name":"Myanmar","name_cn":"缅甸","cover":"http://img.koubeilvxing.com/pics/img/ba/b0/bab0f5818e9788b5761e4802b768e0f4.jpg@!thumb","capitalId":0},{"id":"23427","type":"country","continentId":"32753","countryId":"0","name":"Cambodia","name_cn":"柬埔寨","cover":"http://img.koubeilvxing.com/pics/img/35/12/35126bec6c4b603bb5e5fe6decae9e71.jpg@!thumb","capitalId":0},{"id":"23428","type":"country","continentId":"32753","countryId":"0","name":"Philippines","name_cn":"菲律宾","cover":"http://img.koubeilvxing.com/pics/img/58/d7/58d7c39614b09980b293564cae9f1539.jpg@!thumb","capitalId":0},{"id":"23429","type":"country","continentId":"32753","countryId":"0","name":"Malaysia","name_cn":"马来西亚","cover":"http://img.koubeilvxing.com/pics/img/99/8c/998cf865cc02ecc14b668858b158e0e1.jpg@!thumb","capitalId":0},{"id":"30700","type":"country","continentId":"32753","countryId":"0","name":"Nepal","name_cn":"尼泊尔 ","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/f63067b3bdc4ec34eceeaa3147c6c38a.jpg@!thumb","capitalId":0},{"id":"30701","type":"country","continentId":"32753","countryId":"0","name":"Indonesia","name_cn":"印度尼西亚","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/dbf1ed2103a721509ecf69ad01c29433.jpg@!thumb","capitalId":0},{"id":"30702","type":"country","continentId":"32753","countryId":"0","name":"Vietnam","name_cn":"越南","cover":"http://img.koubeilvxing.com/pics/upload/2014-09-30/542a8737f0a3f.jpg@!thumb","capitalId":0},{"id":"32243","type":"country","continentId":"32753","countryId":"0","name":"Maldives","name_cn":"马尔代夫","cover":"http://img.koubeilvxing.com/pics/img/6f/03/6f0356665d8bd28d2da784b7fd0c6d37.jpg@!thumb","capitalId":"32760"},{"id":"32244","type":"country","continentId":"32753","countryId":"0","name":"Singapore","name_cn":"新加坡","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/5256d9e11d2ea7c9a2e5f1917614a9db.jpg@!thumb","capitalId":"32253"},{"id":"32554","type":"country","continentId":"32753","countryId":"0","name":"Hong Kong","name_cn":"香港","cover":"http://img.koubeilvxing.com/pics/upload/2014-09-30/542a835272ab5.jpg@!thumb","capitalId":"32556"},{"id":"32557","type":"country","continentId":"32753","countryId":"0","name":"Taiwan","name_cn":"台湾","cover":"http://img.koubeilvxing.com/pics/upload/2014-09-30/542a830f97c8b.jpg@!thumb","capitalId":0},{"id":"32603","type":"country","continentId":"32753","countryId":"0","name":"Macau","name_cn":"澳门","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/f8897cfb00735c585cf96c10ef456084.jpg@!thumb","capitalId":"32605"},{"id":"32762","type":"country","continentId":"32753","countryId":"0","name":"Afghanistan","name_cn":"阿富汗","cover":"http://img.koubeilvxing.com/pics/img/f7/ad/f7ad6640c9b99d43ec2acd10c0b99cf3.jpg@!thumb","capitalId":0},{"id":"32763","type":"country","continentId":"32753","countryId":"0","name":"United Arab Emirates","name_cn":"阿联酋","cover":"http://img.koubeilvxing.com/pics/img/00/8f/008f9ab8c56d6a6083a1e3b8317a3466.jpg@!thumb","capitalId":0},{"id":"32764","type":"country","continentId":"32753","countryId":"0","name":"Oman","name_cn":"阿曼","cover":"http://img.koubeilvxing.com/pics/img/36/46/364655900239fb450a21d58ba9d1471d.jpg@!thumb","capitalId":0},{"id":"32765","type":"country","continentId":"32753","countryId":"0","name":"Pakistan","name_cn":"巴基斯坦","cover":"http://img.koubeilvxing.com/pics/img/c9/0a/c90a19020ca79f9cfa2278605ff2e7e8.jpg@!thumb","capitalId":0},{"id":"32766","type":"country","continentId":"32753","countryId":"0","name":"Palestine","name_cn":"巴勒斯坦","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/c0d3c93d042a61375d29743ed4ae0947.jpg@!thumb","capitalId":0},{"id":"32767","type":"country","continentId":"32753","countryId":"0","name":"Bahrain","name_cn":"巴林","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-08/2b7cf3fe0335b7bd806bc645997c5e26.jpg@!thumb","capitalId":"32995"},{"id":"32768","type":"country","continentId":"32753","countryId":"0","name":"Bhutan","name_cn":"不丹","cover":"http://img.koubeilvxing.com/pics/img/6e/0d/6e0da38bfa8af0c33a75ef5ece8611a9.jpg@!thumb","capitalId":0},{"id":"32769","type":"country","continentId":"32753","countryId":"0","name":"North Korea","name_cn":"朝鲜","cover":"http://img.koubeilvxing.com/pics/img/8f/4d/8f4dbf09bb3987c076d7481ae07aae57.jpg@!thumb","capitalId":0},{"id":"32770","type":"country","continentId":"32753","countryId":"0","name":"East Timor","name_cn":"东帝汶","cover":"http://img.koubeilvxing.com/pics/img/71/3c/713c6369576efd233034d608f82403b1.jpg@!thumb","capitalId":0},{"id":"32771","type":"country","continentId":"32753","countryId":"0","name":"Kazakhstan","name_cn":"哈萨克斯坦","cover":"http://img.koubeilvxing.com/pics/img/ee/a9/eea9881b9a169a41cec46636e53d147a.jpg@!thumb","capitalId":0},{"id":"32772","type":"country","continentId":"32753","countryId":"0","name":"Kyrgyzstan","name_cn":"吉尔吉斯斯坦","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-08/a3dd5619e26cc9bd170bcb4059fb5fee.jpg@!thumb","capitalId":0},{"id":"32773","type":"country","continentId":"32753","countryId":"0","name":"Qatar","name_cn":"卡塔尔","cover":"http://img.koubeilvxing.com/pics/img/d8/dd/d8dd158441e7de21870077b923b8c5e9.jpg@!thumb","capitalId":"33091"},{"id":"32775","type":"country","continentId":"32753","countryId":"0","name":"Laos","name_cn":"老挝","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/16428c06effd1bed1cdadbaa1659a0ce.jpg@!thumb","capitalId":0},{"id":"32776","type":"country","continentId":"32753","countryId":"0","name":"Lebanon","name_cn":"黎巴嫩","cover":"http://img.koubeilvxing.com/pics/img/ac/f1/acf1f76f39e2a3cc91fc0cfddd9a9b3a.jpg@!thumb","capitalId":0},{"id":"32777","type":"country","continentId":"32753","countryId":"0","name":"Mongolia","name_cn":"蒙古","cover":"http://img.koubeilvxing.com/pics/upload/2015-11-23/5652e0d71fce7.jpg@!thumb","capitalId":0},{"id":"32778","type":"country","continentId":"32753","countryId":"0","name":"Bangladesh","name_cn":"孟加拉国","cover":"http://img.koubeilvxing.com/pics/upload/2015-11-23/5652de33a1e8b.jpeg@!thumb","capitalId":0},{"id":"32779","type":"country","continentId":"32753","countryId":"0","name":"Saudi Arabia","name_cn":"沙特阿拉伯","cover":"http://img.koubeilvxing.com/pics/img/7d/39/7d39477ac6ae48757cc35e964f0f079d.jpg@!thumb","capitalId":0},{"id":"32780","type":"country","continentId":"32753","countryId":"0","name":"Sri Lanka","name_cn":"斯里兰卡","cover":"http://img.koubeilvxing.com/pics/img/b5/fa/b5fa52ffecac139c07d0ae444b454d41.jpg@!thumb","capitalId":0},{"id":"32781","type":"country","continentId":"32753","countryId":"0","name":"Tajikistan","name_cn":"塔吉克斯坦","cover":"http://img.koubeilvxing.com/pics/img/75/4a/754abf5aeaa9ece5fe3b5e2032808923.jpg@!thumb","capitalId":0},{"id":"32783","type":"country","continentId":"32753","countryId":"0","name":"Brunei","name_cn":"文莱","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/6ed2af4fd38c754f0e08cdfbb6b8ab27.jpg@!thumb","capitalId":0},{"id":"32784","type":"country","continentId":"32753","countryId":"0","name":"Uzbekistan","name_cn":"乌兹别克斯坦","cover":"http://img.koubeilvxing.com/pics/img/c9/04/c904877e8c4e6f6ee32041db91290276.jpg@!thumb","capitalId":0},{"id":"32785","type":"country","continentId":"32753","countryId":"0","name":"Syria","name_cn":"叙利亚","cover":"http://img.koubeilvxing.com/pics/img/47/f3/47f39e6665eb1628ed10d0473a784312.jpg@!thumb","capitalId":0},{"id":"32786","type":"country","continentId":"32753","countryId":"0","name":"Yemen","name_cn":"也门","cover":"http://img.koubeilvxing.com/pics/img/cd/44/cd44f2f2ea900093dc4b3a30afaf334c.jpg@!thumb","capitalId":0},{"id":"32787","type":"country","continentId":"32753","countryId":"0","name":"Iraq","name_cn":"伊拉克","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/399962211f20a8c4e43cfbf60c70a8ce.jpg@!thumb","capitalId":0},{"id":"32788","type":"country","continentId":"32753","countryId":"0","name":"Iran","name_cn":"伊朗","cover":"http://img.koubeilvxing.com/pics/img/d7/4e/d74e8613949a1f4ad2ae56312cb8ffb5.jpg@!thumb","capitalId":0},{"id":"32789","type":"country","continentId":"32753","countryId":"0","name":"British Indian Ocean Territory","name_cn":"英属印度洋领地","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/82063a6806a7031bfc61f65e63a16a2b.jpg@!thumb","capitalId":"33481"},{"id":"32790","type":"country","continentId":"32753","countryId":"0","name":"Israel","name_cn":"以色列","cover":"http://img.koubeilvxing.com/pics/img/44/97/4497c14353bb7366654e173f1fb8cdca.jpg@!thumb","capitalId":0},{"id":"32791","type":"country","continentId":"32753","countryId":"0","name":"Jordan","name_cn":"约旦","cover":"http://img.koubeilvxing.com/pics/img/b4/d2/b4d245b2fafa4cec9980c1085d914082.jpg@!thumb","capitalId":0}]},{"id":"32754","type":"continent","continentId":"0","countryId":"0","name":"Europe","name_cn":"欧洲","cover":"","path":"","countrys":[{"id":"22085","type":"country","continentId":"32754","countryId":"0","name":"France","name_cn":"法国","cover":"http://img.koubeilvxing.com/pics/upload/2015-05-13/555323652ff62.jpg@!thumb","capitalId":0},{"id":"22235","type":"country","continentId":"32754","countryId":"0","name":"Italy","name_cn":"意大利","cover":"http://img.koubeilvxing.com/pics/upload/2015-05-13/5553264ad487a.png@!thumb","capitalId":0},{"id":"22236","type":"country","continentId":"32754","countryId":"0","name":"Greece","name_cn":"希腊","cover":"http://img.koubeilvxing.com/pics/img/71/f9/71f9e79aa828015734536cf08403bcca.jpg@!thumb","capitalId":0},{"id":"22240","type":"country","continentId":"32754","countryId":"0","name":"Spain","name_cn":"西班牙","cover":"http://img.koubeilvxing.com/pics/upload/2015-05-13/5552ff7d13d79.jpg@!thumb","capitalId":0},{"id":"22242","type":"country","continentId":"32754","countryId":"0","name":"United Kingdom","name_cn":"英国","cover":"http://img.koubeilvxing.com/pics/upload/2015-05-13/5553211c0eca2.jpg@!thumb","capitalId":0},{"id":"22243","type":"country","continentId":"32754","countryId":"0","name":"Germany","name_cn":"德国","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-08/9c09e75dc848450bfc9bd05785694edd.jpg@!thumb","capitalId":0},{"id":"24437","type":"country","continentId":"32754","countryId":"0","name":"Belgium","name_cn":"比利时","cover":"http://img.koubeilvxing.com/pics/img/34/99/3499c3409a19cf755bdbf210c3f6b9f0.jpg@!thumb","capitalId":0},{"id":"24438","type":"country","continentId":"32754","countryId":"0","name":"Netherlands","name_cn":"荷兰","cover":"http://img.koubeilvxing.com/pics/img/e5/13/e513d5cf44354f0781386b40b19996a6.jpg@!thumb","capitalId":0},{"id":"24439","type":"country","continentId":"32754","countryId":"0","name":"Sweden","name_cn":"瑞典","cover":"http://img.koubeilvxing.com/pics/img/09/25/0925c27b15a81316ca5b87c3e903eeae.jpg@!thumb","capitalId":0},{"id":"28861","type":"country","continentId":"32754","countryId":"0","name":"Turkey","name_cn":"土耳其","cover":"http://img.koubeilvxing.com/pics/img/09/41/0941c24bb37d03086db1d32d733ab52e.jpg@!thumb","capitalId":0},{"id":"29184","type":"country","continentId":"32754","countryId":"0","name":"Denmark","name_cn":"丹麦","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/1238e13baff276906020f599f8c5fb6a.jpg@!thumb","capitalId":0},{"id":"29240","type":"country","continentId":"32754","countryId":"0","name":"Russia","name_cn":"俄罗斯","cover":"http://img.koubeilvxing.com/pics/img/4e/7c/4e7c4f4d3026f93085dd37852d78a289.jpg@!thumb","capitalId":0},{"id":"30703","type":"country","continentId":"32754","countryId":"0","name":"Austria","name_cn":"奥地利","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/e1ff34c87807e9b97456313c4845c766.jpg@!thumb","capitalId":0},{"id":"31138","type":"country","continentId":"32754","countryId":"0","name":"Czech Republic","name_cn":"捷克共和国","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/559a1402c2f198854de75ffa103977fb.jpg@!thumb","capitalId":0},{"id":"31139","type":"country","continentId":"32754","countryId":"0","name":"Switzerland","name_cn":"瑞士","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/42cf58d450ffd026b9dc47ee78a22ef8.jpg@!thumb","capitalId":0},{"id":"31140","type":"country","continentId":"32754","countryId":"0","name":"Portugal","name_cn":"葡萄牙","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/1fa8be3dfb236fb58c013a3151f12a71.jpg@!thumb","capitalId":0},{"id":"32606","type":"country","continentId":"32754","countryId":"0","name":"Luxembourg","name_cn":"卢森堡","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/65d335bdfe2a141cec554d18d300ea7f.jpg@!thumb","capitalId":0},{"id":"32793","type":"country","continentId":"32754","countryId":"0","name":"Albania","name_cn":"阿尔巴尼亚","cover":"http://img.koubeilvxing.com/pics/img/60/16/6016a1295185843eae447a72c7905b4d.jpg@!thumb","capitalId":0},{"id":"32794","type":"country","continentId":"32754","countryId":"0","name":"Ireland","name_cn":"爱尔兰","cover":"http://img.koubeilvxing.com/pics/img/76/e4/76e49170c7d71abb3c4800728ab3c174.jpg@!thumb","capitalId":0},{"id":"32795","type":"country","continentId":"32754","countryId":"0","name":"Estonia","name_cn":"爱沙尼亚","cover":"http://img.koubeilvxing.com/pics/img/41/97/4197138bea2e5d6ecd0eaccf9a432af0.jpg@!thumb","capitalId":0},{"id":"32796","type":"country","continentId":"32754","countryId":"0","name":"Andorra","name_cn":"安道尔","cover":"http://img.koubeilvxing.com/pics/img/ed/50/ed503a13150e23c076358f8d271a6a73.jpg@!thumb","capitalId":"33577"},{"id":"32797","type":"country","continentId":"32754","countryId":"0","name":"Azerbaijan","name_cn":"阿塞拜疆","cover":"http://img.koubeilvxing.com/pics/img/a3/92/a3927898a5f95d99a032cb8405eb3998.jpg@!thumb","capitalId":0},{"id":"32798","type":"country","continentId":"32754","countryId":"0","name":"Belarus","name_cn":"白俄罗斯","cover":"http://img.koubeilvxing.com/pics/img/be/1c/be1c2d9b55fc2e20bcb2c813ba5cd149.jpg@!thumb","capitalId":0},{"id":"32799","type":"country","continentId":"32754","countryId":"0","name":"Bulgaria","name_cn":"保加利亚","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-08/537462903d26e7bc408a0baead64d265.jpg@!thumb","capitalId":0},{"id":"32800","type":"country","continentId":"32754","countryId":"0","name":"Iceland","name_cn":"冰岛","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/aa6b7c1f3bb79075350ed45b9675b075.jpg@!thumb","capitalId":0},{"id":"32802","type":"country","continentId":"32754","countryId":"0","name":"Poland","name_cn":"波兰","cover":"http://img.koubeilvxing.com/pics/img/95/07/9507760eba069a7d3d50177ddd38b0aa.jpg@!thumb","capitalId":0},{"id":"32803","type":"country","continentId":"32754","countryId":"0","name":"Faroe Islands","name_cn":"法罗群岛","cover":"http://img.koubeilvxing.com/pics/img/02/fd/02fd3f97fe4428ba79c8e976285b7742.jpg@!thumb","capitalId":0},{"id":"32805","type":"country","continentId":"32754","countryId":"0","name":"Finland","name_cn":"芬兰","cover":"http://img.koubeilvxing.com/pics/img/8f/cf/8fcf94f6f22e7c94de0bdc4938450de2.jpg@!thumb","capitalId":0},{"id":"32806","type":"country","continentId":"32754","countryId":"0","name":"Greenland","name_cn":"格陵兰","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-08/4ae08bc88979adf68776b123a64ec36c.jpg@!thumb","capitalId":0},{"id":"32807","type":"country","continentId":"32754","countryId":"0","name":"Georgia","name_cn":"格鲁吉亚","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/8b4bde3103321184ceb3ce695c450133.jpg@!thumb","capitalId":0},{"id":"32808","type":"country","continentId":"32754","countryId":"0","name":"Montenegro","name_cn":"黑山","cover":"http://img.koubeilvxing.com/pics/img/8f/b6/8fb6b8841628857711bc52d37b192063.jpg@!thumb","capitalId":0},{"id":"32809","type":"country","continentId":"32754","countryId":"0","name":"Croatia","name_cn":"克罗地亚","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/d73914c2cc025c362b56f5b58c7578fa.jpg@!thumb","capitalId":0},{"id":"32811","type":"country","continentId":"32754","countryId":"0","name":"Latvia","name_cn":"拉脱维亚","cover":"http://img.koubeilvxing.com/pics/img/c7/9a/c79ab18c248462d8f29003aad9903067.jpg@!thumb","capitalId":0},{"id":"32812","type":"country","continentId":"32754","countryId":"0","name":"Liechtenstein","name_cn":"列支敦士登","cover":"http://img.koubeilvxing.com/pics/img/77/da/77da6d97f043c59735625ca1a30b9c1c.jpg@!thumb","capitalId":"33966"},{"id":"32813","type":"country","continentId":"32754","countryId":"0","name":"Lithuania","name_cn":"立陶宛","cover":"http://img.koubeilvxing.com/pics/img/75/2c/752ce04ede2caf2545578465825ca579.jpg@!thumb","capitalId":0},{"id":"32814","type":"country","continentId":"32754","countryId":"0","name":"Romania","name_cn":"罗马尼亚","cover":"http://img.koubeilvxing.com/pics/img/7b/a4/7ba46ddf4e9e6e0c9b3db421a3103916.jpg@!thumb","capitalId":0},{"id":"32815","type":"country","continentId":"32754","countryId":"0","name":"Malta","name_cn":"马耳他","cover":"http://img.koubeilvxing.com/pics/img/22/f6/22f67ea1ec7a6b1c93638ea9bb44b61f.jpg@!thumb","capitalId":0},{"id":"32816","type":"country","continentId":"32754","countryId":"0","name":"Macedonia","name_cn":"马其顿","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/2b79316f82f10aed9933f86a93dde71b.jpg@!thumb","capitalId":0},{"id":"32817","type":"country","continentId":"32754","countryId":"0","name":"Moldova","name_cn":"摩尔多瓦","cover":"http://img.koubeilvxing.com/pics/img/df/6e/df6e4c2b0111c83dd3713ef17e4c10ad.jpg@!thumb","capitalId":0},{"id":"32819","type":"country","continentId":"32754","countryId":"0","name":"Norway","name_cn":"挪威","cover":"http://img.koubeilvxing.com/pics/img/44/e1/44e1e6a8be64acbccddcaa28aed2b017.jpg@!thumb","capitalId":0},{"id":"32820","type":"country","continentId":"32754","countryId":"0","name":"Serbia","name_cn":"塞尔维亚","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/43ca7c2b463c13c7f323d6744c4b4f8a.jpg@!thumb","capitalId":0},{"id":"32821","type":"country","continentId":"32754","countryId":"0","name":"Cyprus","name_cn":"塞浦路斯","cover":"http://img.koubeilvxing.com/pics/img/ea/8a/ea8ad77c4fcc464ca3065a2b6100b283.jpg@!thumb","capitalId":0},{"id":"32823","type":"country","continentId":"32754","countryId":"0","name":"Slovakia","name_cn":"斯洛伐克","cover":"http://img.koubeilvxing.com/pics/img/2b/ae/2baef3b22626c955c976576f75cd9841.jpg@!thumb","capitalId":0},{"id":"32824","type":"country","continentId":"32754","countryId":"0","name":"Slovenia","name_cn":"斯洛文尼亚","cover":"http://img.koubeilvxing.com/pics/img/42/f3/42f3b155633417913c114444bfc756dc.jpg@!thumb","capitalId":0},{"id":"32825","type":"country","continentId":"32754","countryId":"0","name":"Ukraine","name_cn":"乌克兰","cover":"http://img.koubeilvxing.com/pics/img/77/89/7789a7ea2a29eee57ae1b0da752775b6.jpg@!thumb","capitalId":0},{"id":"32827","type":"country","continentId":"32754","countryId":"0","name":"Hungary","name_cn":"匈牙利","cover":"http://img.koubeilvxing.com/pics/img/25/43/2543db6850da51703643c27325abc568.jpg@!thumb","capitalId":0},{"id":"32828","type":"country","continentId":"32754","countryId":"0","name":"Armenia","name_cn":"亚美尼亚","cover":"http://img.koubeilvxing.com/pics/img/5e/86/5e86cf63da62226aa860e940e684bc58.jpg@!thumb","capitalId":0}]},{"id":"32755","type":"continent","continentId":"0","countryId":"0","name":"North America","name_cn":"北美洲","cover":"","path":"","countrys":[{"id":"5040","type":"country","continentId":"32755","countryId":"0","name":"United States","name_cn":"美国","cover":"http://img.koubeilvxing.com/pics/upload/2015-05-13/5553208019b8e.jpg@!thumb","capitalId":0},{"id":"22241","type":"country","continentId":"32755","countryId":"0","name":"Canada","name_cn":"加拿大","cover":"http://img.koubeilvxing.com/pics/img/46/54/4654457737651e25b0a77820befb174e.jpg@!thumb","capitalId":0},{"id":"29745","type":"country","continentId":"32755","countryId":"0","name":"Mexico","name_cn":"墨西哥","cover":"http://img.koubeilvxing.com/pics/upload/2014-09-30/542a73db0c3fa.jpg@!thumb","capitalId":0},{"id":"29746","type":"country","continentId":"32755","countryId":"0","name":"Costa Rica","name_cn":"哥斯达黎加","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/877cbe7e04c3825a9a80d06112d4c6e1.jpg@!thumb","capitalId":0},{"id":"29747","type":"country","continentId":"32755","countryId":"0","name":"Jamaica","name_cn":"牙买加","cover":"http://img.koubeilvxing.com/pics/upload/2014-09-30/542a8563ee2a1.jpg@!thumb","capitalId":0},{"id":"31141","type":"country","continentId":"32755","countryId":"0","name":"Bahamas","name_cn":"巴哈马","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/7684c8f7d289e5ba98d99defe4a842d7.jpg@!thumb","capitalId":0},{"id":"32245","type":"country","continentId":"32755","countryId":"0","name":"Panama","name_cn":"巴拿马","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/7b2dbdbed843cf68d53ea1712cca2ee7.jpg@!thumb","capitalId":0},{"id":"32246","type":"country","continentId":"32755","countryId":"0","name":"Guatemala","name_cn":"危地马拉","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/619411addaf1d5884277a4af24a36f0f.jpg@!thumb","capitalId":0},{"id":"32382","type":"country","continentId":"32755","countryId":"0","name":"Cuba","name_cn":"古巴","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/c82132edc74b8463ea237bc467d68463.jpg@!thumb","capitalId":0},{"id":"32884","type":"country","continentId":"32755","countryId":"0","name":"Anguilla","name_cn":"安圭拉","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/d5ef389563206401fd010e805699d3e3.jpg@!thumb","capitalId":"34877"},{"id":"32886","type":"country","continentId":"32755","countryId":"0","name":"Barbados","name_cn":"巴巴多斯","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/b8d3b73e8bdb996efcb7cf41ae20fd4a.jpg@!thumb","capitalId":0},{"id":"32888","type":"country","continentId":"32755","countryId":"0","name":"Puerto Rico","name_cn":"波多黎各","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/677b6899b61f3f1e94b6c12f7592dad3.jpg@!thumb","capitalId":0},{"id":"32889","type":"country","continentId":"32755","countryId":"0","name":"Belize","name_cn":"伯利兹","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-08/b246ffb4ac876db2251475c4b17a547e.jpg@!thumb","capitalId":0},{"id":"32890","type":"country","continentId":"32755","countryId":"0","name":"Aruba","name_cn":"阿鲁巴","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/24083bc54429cb53d435fea7dd742a68.jpg@!thumb","capitalId":"34926"},{"id":"32893","type":"country","continentId":"32755","countryId":"0","name":"Dominica","name_cn":"多米尼克","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/3b8eb0c8d4935ebb2392b421be732732.jpg@!thumb","capitalId":0},{"id":"32894","type":"country","continentId":"32755","countryId":"0","name":"Saint Martin","name_cn":"法属圣马丁","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/9c686975817f320a913dd5ccc63944a5.jpg@!thumb","capitalId":"34936"},{"id":"32898","type":"country","continentId":"32755","countryId":"0","name":"Sint Maarten","name_cn":"荷属圣马丁","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/03545d2dd729045a9fc423d47123192a.jpg@!thumb","capitalId":"34963"},{"id":"32899","type":"country","continentId":"32755","countryId":"0","name":"Honduras","name_cn":"洪都拉斯","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-08/a155e9a407d67b4b36e314cc69e0cbf1.jpg@!thumb","capitalId":0},{"id":"32900","type":"country","continentId":"32755","countryId":"0","name":"Cayman Islands","name_cn":"开曼群岛","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/fa1ddce8e4333e59da09e5dcc786ac45.jpg@!thumb","capitalId":0},{"id":"32905","type":"country","continentId":"32755","countryId":"0","name":"Nicaragua","name_cn":"尼加拉瓜","cover":"http://img.koubeilvxing.com/pics/img/f5/bf/f5bfa68efa5081e7e82f04bbb71ebd87.jpg@!thumb","capitalId":0},{"id":"32907","type":"country","continentId":"32755","countryId":"0","name":"El Salvador","name_cn":"萨尔瓦多","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-08/0fcbea2ad3b306aa37993f6c4de82bcd.jpg@!thumb","capitalId":0},{"id":"32915","type":"country","continentId":"32755","countryId":"0","name":"Trinidad & Tobago","name_cn":"特立尼达和多巴哥","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/d25aad2855953a02067a5fbfee8d12d0.jpg@!thumb","capitalId":0}]},{"id":"32756","type":"continent","continentId":"0","countryId":"0","name":"South America","name_cn":"南美洲","cover":"","path":"","countrys":[{"id":"29750","type":"country","continentId":"32756","countryId":"0","name":"Argentina","name_cn":"阿根廷","cover":"http://img.koubeilvxing.com/pics/upload/2014-09-30/542a74fc37bb7.jpg@!thumb","capitalId":0},{"id":"29751","type":"country","continentId":"32756","countryId":"0","name":"Brazil","name_cn":"巴西","cover":"http://img.koubeilvxing.com/pics/upload/2014-09-30/542a76a588e5c.jpg@!thumb","capitalId":0},{"id":"29752","type":"country","continentId":"32756","countryId":"0","name":"Peru","name_cn":"秘鲁","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/041db3582546fa8cd5e5973f832a450f.jpg@!thumb","capitalId":0},{"id":"29753","type":"country","continentId":"32756","countryId":"0","name":"Bolivia","name_cn":"玻利维亚","cover":"http://img.koubeilvxing.com/pics/upload/2014-09-30/542a85c4c8586.jpg@!thumb","capitalId":0},{"id":"32918","type":"country","continentId":"32756","countryId":"0","name":"Ecuador","name_cn":"厄瓜多尔","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/797aec60eb5d97de0431f03e7c2995b4.jpg@!thumb","capitalId":0},{"id":"32919","type":"country","continentId":"32756","countryId":"0","name":"French Guiana","name_cn":"法属圭亚那","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-08/39ab1376056d8c70d275ff1f494b9fe7.jpg@!thumb","capitalId":0},{"id":"32921","type":"country","continentId":"32756","countryId":"0","name":"Colombia","name_cn":"哥伦比亚","cover":"http://img.koubeilvxing.com/pics/img/da/b6/dab6e4c134e5baf9733e84ffb2e80738.jpg@!thumb","capitalId":0},{"id":"32922","type":"country","continentId":"32756","countryId":"0","name":"Guyana","name_cn":"圭亚那","cover":"http://img.koubeilvxing.com/pics/img/1d/22/1d224fdc0c41e2d58c5d0a9b59143c16.jpg@!thumb","capitalId":0},{"id":"32923","type":"country","continentId":"32756","countryId":"0","name":"Suriname","name_cn":"苏里南","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-08/6f1af40a1107c2958972dabd2fd02ced.jpg@!thumb","capitalId":0},{"id":"32924","type":"country","continentId":"32756","countryId":"0","name":"Venezuela","name_cn":"委内瑞拉","cover":"http://img.koubeilvxing.com/pics/img/f4/02/f4022aa74ee6800ed2d7d2bb9d6e24e3.jpg@!thumb","capitalId":0},{"id":"32925","type":"country","continentId":"32756","countryId":"0","name":"Uruguay","name_cn":"乌拉圭","cover":"http://img.koubeilvxing.com/pics/img/8e/97/8e97702857cb41332ebf118f8bf77982.jpg@!thumb","capitalId":0},{"id":"32926","type":"country","continentId":"32756","countryId":"0","name":"Chile","name_cn":"智利","cover":"http://img.koubeilvxing.com/pics/img/c5/94/c59453ff5f99298d8b195b6ccd55f52c.jpg@!thumb","capitalId":0}]},{"id":"32757","type":"continent","continentId":"0","countryId":"0","name":"Africa","name_cn":"非洲","cover":"","path":"","countrys":[{"id":"22244","type":"country","continentId":"32757","countryId":"0","name":"Egypt","name_cn":"埃及","cover":"http://img.koubeilvxing.com/pics/upload/2015-05-13/555320f79413e.jpg@!thumb","capitalId":0},{"id":"31142","type":"country","continentId":"32757","countryId":"0","name":"South Africa","name_cn":"南非 ","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/f52a305f0bbce38849047cfb259eda30.jpg@!thumb","capitalId":0},{"id":"31143","type":"country","continentId":"32757","countryId":"0","name":"Kenya","name_cn":"肯尼亚","cover":"http://img.koubeilvxing.com/pics/upload/2014-09-30/542a7f132fed5.jpg@!thumb","capitalId":0},{"id":"31144","type":"country","continentId":"32757","countryId":"0","name":"Morocco","name_cn":"摩洛哥","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-08/eb9614a3f7fb4289a68996d63c2fd7bf.jpg@!thumb","capitalId":0},{"id":"31145","type":"country","continentId":"32757","countryId":"0","name":"Tanzania","name_cn":"坦桑尼亚","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/ea046617e2c07d1c8948b2350b83e56b.jpg@!thumb","capitalId":0},{"id":"32250","type":"country","continentId":"32757","countryId":"0","name":"Mauritius","name_cn":"毛里求斯","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-08/77b3ad285e1120c7d5bc698d6b76be08.jpg@!thumb","capitalId":0},{"id":"32251","type":"country","continentId":"32757","countryId":"0","name":"Tunisia","name_cn":"突尼斯","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/2afb5bacc34df6d9274aa345417a595b.jpg@!thumb","capitalId":0},{"id":"32830","type":"country","continentId":"32757","countryId":"0","name":"Algeria","name_cn":"阿尔及利亚","cover":"http://img.koubeilvxing.com/pics/img/32/fb/32fbf6ee18f7a3e82a59c0f92cd03725.jpg@!thumb","capitalId":0},{"id":"32831","type":"country","continentId":"32757","countryId":"0","name":"Ethiopia","name_cn":"埃塞俄比亚","cover":"http://img.koubeilvxing.com/pics/img/71/d1/71d1bf188a7c415a7601bb22c43211b0.jpg@!thumb","capitalId":0},{"id":"32832","type":"country","continentId":"32757","countryId":"0","name":"Angola","name_cn":"安哥拉","cover":"http://img.koubeilvxing.com/pics/img/2c/ad/2cad5d459995d0e7561f2cbe13729ec5.jpg@!thumb","capitalId":0},{"id":"32834","type":"country","continentId":"32757","countryId":"0","name":"Somalia","name_cn":"索马里","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/e691ede11107957cfc0f4f281489aa53.jpg@!thumb","capitalId":0},{"id":"32835","type":"country","continentId":"32757","countryId":"0","name":"Benin","name_cn":"贝宁","cover":"http://img.koubeilvxing.com/pics/img/87/83/8783bf50e9efe1b436dde0d25a5805d3.jpg@!thumb","capitalId":0},{"id":"32837","type":"country","continentId":"32757","countryId":"0","name":"Botswana","name_cn":"博茨瓦纳","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-08/91d102617c00a62a316e32cb8fe626ea.jpg@!thumb","capitalId":0},{"id":"32838","type":"country","continentId":"32757","countryId":"0","name":"Burkina Faso","name_cn":"布基纳法索","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/076e2b0c028ba6b608d29f8a38a625b1.jpg@!thumb","capitalId":0},{"id":"32839","type":"country","continentId":"32757","countryId":"0","name":"Burundi","name_cn":"布隆迪","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-08/271239d880ba791dc66317511c2114fa.jpg@!thumb","capitalId":0},{"id":"32840","type":"country","continentId":"32757","countryId":"0","name":"Equatorial Guinea","name_cn":"赤道几内亚","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/e375b282e5ae0ded6a21b9a2313e6f0d.jpg@!thumb","capitalId":0},{"id":"32842","type":"country","continentId":"32757","countryId":"0","name":"Togo","name_cn":"多哥","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-08/c7971345b279ec1c5da7cbc41c2e4aae.jpg@!thumb","capitalId":0},{"id":"32844","type":"country","continentId":"32757","countryId":"0","name":"Gambia","name_cn":"冈比亚","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-08/7aba8ffa6ff25683863ef9aa463fb53f.jpg@!thumb","capitalId":0},{"id":"32847","type":"country","continentId":"32757","countryId":"0","name":"Ghana","name_cn":"加纳","cover":"http://img.koubeilvxing.com/pics/img/e1/a4/e1a43668871b15b7a7de460210be847f.jpg@!thumb","capitalId":0},{"id":"32848","type":"country","continentId":"32757","countryId":"0","name":"Gabon","name_cn":"加蓬","cover":"http://img.koubeilvxing.com/pics/img/7b/4b/7b4bd8efde72658d46f724c45505eb41.jpg@!thumb","capitalId":0},{"id":"32850","type":"country","continentId":"32757","countryId":"0","name":"Zimbabwe","name_cn":"津巴布韦","cover":"http://img.koubeilvxing.com/pics/img/83/df/83dfea7354906e56706dd5640aea1555.jpg@!thumb","capitalId":0},{"id":"32851","type":"country","continentId":"32757","countryId":"0","name":"Guinea","name_cn":"几内亚","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-08/baf2f70d422e4740752af6678df6ad8b.jpg@!thumb","capitalId":0},{"id":"32852","type":"country","continentId":"32757","countryId":"0","name":"Guinea Bissau","name_cn":"几内亚比绍","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/7a90929db185ce0648f485f819a2364e.jpg@!thumb","capitalId":0},{"id":"32855","type":"country","continentId":"32757","countryId":"0","name":"Cote Divoire","name_cn":"科特迪瓦","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/8d3fe60174912ed1df139098f54b36c4.jpg@!thumb","capitalId":0},{"id":"32856","type":"country","continentId":"32757","countryId":"0","name":"Lesotho","name_cn":"莱索托","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-08/29360d41406aa6533be9f1fd96be9d74.jpg@!thumb","capitalId":0},{"id":"32857","type":"country","continentId":"32757","countryId":"0","name":"Liberia","name_cn":"利比里亚","cover":"http://img.koubeilvxing.com/pics/img/b0/b7/b0b7e133dd57da43c053327836799de9.jpg@!thumb","capitalId":0},{"id":"32858","type":"country","continentId":"32757","countryId":"0","name":"Libya","name_cn":"利比亚","cover":"http://img.koubeilvxing.com/pics/img/c0/f6/c0f6b0de159cad5ad257108c046bc65e.jpg@!thumb","capitalId":0},{"id":"32860","type":"country","continentId":"32757","countryId":"0","name":"Rwanda","name_cn":"卢旺达","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/0794b516f054a7f14d0b00bb28bfcf25.jpg@!thumb","capitalId":0},{"id":"32861","type":"country","continentId":"32757","countryId":"0","name":"Madagascar","name_cn":"马达加斯加","cover":"http://img.koubeilvxing.com/pics/img/f5/c4/f5c4f8346b5c0e26fa31f1fa43e80dd4.jpg@!thumb","capitalId":0},{"id":"32862","type":"country","continentId":"32757","countryId":"0","name":"Malawi","name_cn":"马拉维","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-08/930ed2efca5016c214385645656f45f8.jpg@!thumb","capitalId":0},{"id":"32863","type":"country","continentId":"32757","countryId":"0","name":"Mali","name_cn":"马里","cover":"http://img.koubeilvxing.com/pics/img/f0/a7/f0a7ecb123758a106d6d43dae4a5bfa7.jpg@!thumb","capitalId":0},{"id":"32864","type":"country","continentId":"32757","countryId":"0","name":"Mauritania","name_cn":"毛里塔尼亚","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/75b553f733b926a474355cdec34e4ea8.jpg@!thumb","capitalId":0},{"id":"32866","type":"country","continentId":"32757","countryId":"0","name":"Mozambique","name_cn":"莫桑比克","cover":"http://img.koubeilvxing.com/pics/img/b0/93/b093ea7f7240c17c0d9a2548d01301f9.jpg@!thumb","capitalId":0},{"id":"32867","type":"country","continentId":"32757","countryId":"0","name":"Namibia","name_cn":"纳米比亚","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/feeb2ae1c579a287788f92e5736d3fdc.jpg@!thumb","capitalId":0},{"id":"32868","type":"country","continentId":"32757","countryId":"0","name":"South Sudan","name_cn":"南苏丹","cover":"http://img.koubeilvxing.com/pics/img/e2/0f/e20fa9f0c0f33d6c673fcfb4a4eb3e7e.jpg@!thumb","capitalId":"34739"},{"id":"32870","type":"country","continentId":"32757","countryId":"0","name":"Nigeria","name_cn":"尼日利亚","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/175845e30d6ad963156612c2349a45f3.jpg@!thumb","capitalId":0},{"id":"32872","type":"country","continentId":"32757","countryId":"0","name":"Senegal","name_cn":"塞内加尔","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/732ec041233118b5be4ff5f592f04d3a.jpg@!thumb","capitalId":0},{"id":"32873","type":"country","continentId":"32757","countryId":"0","name":"Seychelles","name_cn":"塞舌尔","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/057fffa8e747adf49fb08ad58b1178b6.jpg@!thumb","capitalId":0},{"id":"32876","type":"country","continentId":"32757","countryId":"0","name":"Swaziland","name_cn":"斯威士兰","cover":"http://img.koubeilvxing.com/pics/img/82/3e/823eb651c98f60177100617dfdf562ef.jpg@!thumb","capitalId":0},{"id":"32877","type":"country","continentId":"32757","countryId":"0","name":"Sudan","name_cn":"苏丹","cover":"http://img.koubeilvxing.com/pics/img/1d/ea/1dea7db8ca7ca8c895e69971e97a5acb.jpg@!thumb","capitalId":0},{"id":"32878","type":"country","continentId":"32757","countryId":"0","name":"Tristan da Cunha","name_cn":"特里斯坦-达库尼亚群岛","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/1a397e0953f4a7a49e60918d5bf95f41.jpg@!thumb","capitalId":"34825"},{"id":"32879","type":"country","continentId":"32757","countryId":"0","name":"Uganda","name_cn":"乌干达","cover":"http://img.koubeilvxing.com/pics/img/e4/e0/e4e04de5e0edd32d4ad093349fec902f.jpg@!thumb","capitalId":0},{"id":"32881","type":"country","continentId":"32757","countryId":"0","name":"Zambia","name_cn":"赞比亚","cover":"http://img.koubeilvxing.com/pics/img/ca/0d/ca0dafb98d9fa94fb0072f95150dbb86.jpg@!thumb","capitalId":0},{"id":"32883","type":"country","continentId":"32757","countryId":"0","name":"Central African Republic","name_cn":"中非共和国","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-08/c4fe389491d5abc9a952241765565a19.jpg@!thumb","capitalId":0}]},{"id":"32758","type":"continent","continentId":"0","countryId":"0","name":"Oceania","name_cn":"大洋洲","cover":"","path":"","countrys":[{"id":"22237","type":"country","continentId":"32758","countryId":"0","name":"Australia","name_cn":"澳大利亚","cover":"http://img.koubeilvxing.com/pics/upload/2015-05-13/5552c429f014f.jpg@!thumb","capitalId":0},{"id":"22239","type":"country","continentId":"32758","countryId":"0","name":"New Zealand","name_cn":"新西兰","cover":"http://img.koubeilvxing.com/pics/img/cb/78/cb786864e775ec5fa0bd518a69e46201.jpg@!thumb","capitalId":0},{"id":"30698","type":"country","continentId":"32758","countryId":"0","name":"French Polynesia","name_cn":"法属波利尼西亚","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/ebc57025308fb368a7ee0a685971f878.jpg@!thumb","capitalId":0},{"id":"30699","type":"country","continentId":"32758","countryId":"0","name":"Northern Mariana Islands","name_cn":"北马里亚纳群岛邦","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/9be9bb179be54d0862283f0d5d181dd7.jpg@!thumb","capitalId":0},{"id":"32247","type":"country","continentId":"32758","countryId":"0","name":"Fiji","name_cn":"斐济","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/3b3143cefa15e8401155ee6a782ecaf1.jpg@!thumb","capitalId":0},{"id":"32248","type":"country","continentId":"32758","countryId":"0","name":"Guam","name_cn":"关岛","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-08/406f16657adb8b2d56a17c5e1de213e1.jpg@!thumb","capitalId":0},{"id":"32471","type":"country","continentId":"32758","countryId":"0","name":"Palau","name_cn":"帕劳","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-08/916201f8e3111d62ca4178f4755b1b56.jpg@!thumb","capitalId":0},{"id":"32928","type":"country","continentId":"32758","countryId":"0","name":"Papua New Guinea","name_cn":"巴布亚新几内亚","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-08/1d90945af9165160cdb284fbc3e320d6.jpg@!thumb","capitalId":0},{"id":"32932","type":"country","continentId":"32758","countryId":"0","name":"American Samoa","name_cn":"美属萨摩亚","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-08/6280c458f265a5369713572f9032e0a8.jpg@!thumb","capitalId":0},{"id":"32935","type":"country","continentId":"32758","countryId":"0","name":"Niue","name_cn":"纽埃","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-08/6313c9eee0f181d248a6519a7f9a849c.jpg@!thumb","capitalId":"35413"},{"id":"32937","type":"country","continentId":"32758","countryId":"0","name":"Samoa","name_cn":"萨摩亚","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-08/aebc7f42514068240e0593424d00ec31.jpg@!thumb","capitalId":0},{"id":"32938","type":"country","continentId":"32758","countryId":"0","name":"Solomon Islands","name_cn":"所罗门群岛","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-08/3cb8cb4d8a9bc23589e0ed32371750fd.jpg@!thumb","capitalId":0},{"id":"32939","type":"country","continentId":"32758","countryId":"0","name":"Tonga","name_cn":"汤加","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-08/e7aa0fc70152f19d825f1318b66a1166.jpg@!thumb","capitalId":0},{"id":"32943","type":"country","continentId":"32758","countryId":"0","name":"Vanuatu","name_cn":"瓦努阿图","cover":"http://img.koubeilvxing.com/pics/img/69/3b/693b488da71e45f017d1443de7dec945.jpg@!thumb","capitalId":0},{"id":"32944","type":"country","continentId":"32758","countryId":"0","name":"New Caledonia","name_cn":"新喀里多尼亚","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/13d8749e4cf64a7a94ceb5313f22e7ac.jpg@!thumb","capitalId":0}]}]
     * recommendplaces : [{"id":"326","name":"Bangkok","name_cn":"曼谷","cover":"http://img.koubeilvxing.com/pics/upload/2015-07-28/55b6d992efaed.jpg@!thumb","desc":"佛教之都，包罗万象","info_cn":"","info":""},{"id":"32253","name":"Singapore","name_cn":"新加坡","cover":"http://img.koubeilvxing.com/pics/upload/2014-09-30/542a693a98374.jpg@!thumb","desc":"狮城美港，星洲花园","info_cn":"","info":""},{"id":"19039","name":"New York","name_cn":"纽约","cover":"http://img.koubeilvxing.com/pics/upload/2015-07-28/55b6d9f979216.jpg@!thumb","desc":"世界金融中心，不尽繁华","info_cn":"","info":""},{"id":"22115","name":"Paris","name_cn":"巴黎","cover":"http://img.koubeilvxing.com/pics/upload/2015-07-28/55b6da3cc04a9.jpg@!thumb","desc":"光之城，法兰西的心脏与灵魂","info_cn":"","info":""},{"id":"22522","name":"Sydney","name_cn":"悉尼","cover":"http://img.koubeilvxing.com/pics/upload/2015-07-28/55b6da65275c7.jpg@!thumb","desc":"邂逅在慵懒的海湾","info_cn":"","info":""},{"id":"23128","name":"Cairo","name_cn":"开罗","cover":"http://img.koubeilvxing.com/pics/upload/2015-07-28/55b6da7e97981.jpg@!thumb","desc":"每一座金字塔都有一千零一个故事","info_cn":"","info":""},{"id":"22951","name":"London","name_cn":"伦敦","cover":"http://img.koubeilvxing.com/pics/upload/2015-07-28/55b6daa0b5113.jpg@!thumb","desc":"古典与现代完美交融","info_cn":"","info":""},{"id":"22274","name":"Milan","name_cn":"米兰","cover":"http://img.koubeilvxing.com/pics/upload/2015-07-28/55b6dab907c9a.jpg@!thumb","desc":"艺术之城，时尚之都，歌剧圣地","info_cn":"","info":""},{"id":"22349","name":"Venice","name_cn":"威尼斯","cover":"http://img.koubeilvxing.com/pics/upload/2015-07-28/55b6dad2bbae8.jpg@!thumb","desc":"因水而生，欧洲最美的客厅","info_cn":"","info":""},{"id":"22820","name":"Barcelona","name_cn":"巴塞罗那","cover":"http://img.koubeilvxing.com/pics/upload/2015-07-28/55b6daf30f6d9.jpg@!thumb","desc":"足球圣地，世界建筑艺术殿堂","info_cn":"","info":""},{"id":"31235","name":"Prague","name_cn":"布拉格","cover":"http://img.koubeilvxing.com/pics/upload/2015-07-28/55b6eca4d1993.jpg@!thumb","desc":"千塔之城，金色的布拉格","info_cn":"","info":""},{"id":"23014","name":"Munich","name_cn":"慕尼黑","cover":"http://img.koubeilvxing.com/pics/upload/2015-07-28/55b6db0fc8878.jpg@!thumb","desc":"爱足球，爱啤酒","info_cn":"","info":""},{"id":"32556","name":"Hong Kong","name_cn":"香港","cover":"http://img.koubeilvxing.com/pics/upload/2015-07-28/55b6ed01547ec.jpg@!thumb","desc":"东方之珠，购物天堂","info_cn":"","info":""},{"id":"32605","name":"Macau","name_cn":"澳门","cover":"http://img.koubeilvxing.com/pics/upload/2015-07-28/55b6eb6b54ca8.jpg@!thumb","desc":"400年中西文化磨合，东方赌城","info_cn":"","info":""},{"id":"32593","name":"Taipei","name_cn":"台北","cover":"http://img.koubeilvxing.com/pics/upload/2015-07-28/55b6db296a6c4.jpg@!thumb","desc":"阿里山，日月潭，赛德克巴莱","info_cn":"","info":""},{"id":"353","name":"Chiang Mai","name_cn":"清迈","cover":"http://img.koubeilvxing.com/pics/upload/2015-07-28/55b6db42f1606.jpg@!thumb","desc":"泰北明珠，清新文艺的古城","info_cn":"","info":""},{"id":"23369","name":"Seoul","name_cn":"首尔","cover":"http://img.koubeilvxing.com/pics/upload/2015-07-28/55b6db5b03e2f.jpg@!thumb","desc":"600年古都，时尚与传统交相辉映","info_cn":"","info":""},{"id":"23261","name":"Tokyo","name_cn":"东京","cover":"http://img.koubeilvxing.com/pics/upload/2015-07-28/55b6db705bec6.jpg@!thumb","desc":"宫崎骏的动画，黑泽明的电影","info_cn":"","info":""},{"id":"9742","name":"Los Angeles","name_cn":"洛杉矶","cover":"http://img.koubeilvxing.com/pics/upload/2015-07-28/55b6eb96aa3b7.jpg@!thumb","desc":"好莱坞，迪斯尼，湖人队","info_cn":"","info":""},{"id":"9604","name":"San Francisco","name_cn":"旧金山","cover":"http://img.koubeilvxing.com/pics/upload/2015-07-28/55b6ebf5c0229.jpg@!thumb","desc":"前卫与不羁，嬉皮士的狂欢之城","info_cn":"","info":""},{"id":"22932","name":"Toronto","name_cn":"多伦多","cover":"http://img.koubeilvxing.com/pics/upload/2015-07-28/55b6dbb6ecc05.jpg@!thumb","desc":"北方好莱坞，城市万花筒","info_cn":"","info":""},{"id":"22324","name":"Rome","name_cn":"罗马","cover":"http://img.koubeilvxing.com/pics/upload/2015-07-28/55b6dbcf43261.jpg@!thumb","desc":"天使之城，文艺复兴中心","info_cn":"","info":""}]
     */

    private int ret;
    /**
     * id : 32753
     * type : continent
     * continentId : 0
     * countryId : 0
     * name : Asia
     * name_cn : 亚洲
     * cover :
     * path :
     * countrys : [{"id":"1","type":"country","continentId":"32753","countryId":"0","name":"Thailand","name_cn":"泰国","cover":"http://img.koubeilvxing.com/pics/upload/2015-07-28/55b6d992efaed.jpg@!thumb","capitalId":0},{"id":"22238","type":"country","continentId":"32753","countryId":"0","name":"India","name_cn":"印度","cover":"http://img.koubeilvxing.com/pics/upload/2014-09-30/542a6c0bae9bc.jpg@!thumb","capitalId":0},{"id":"23131","type":"country","continentId":"32753","countryId":"0","name":"Japan","name_cn":"日本","cover":"http://img.koubeilvxing.com/pics/upload/2015-05-13/55532586b131c.jpg@!thumb","capitalId":0},{"id":"23277","type":"country","continentId":"32753","countryId":"0","name":"South Korea","name_cn":"韩国","cover":"http://img.koubeilvxing.com/pics/upload/2015-05-13/55532556374ef.jpg@!thumb","capitalId":0},{"id":"23373","type":"country","continentId":"32753","countryId":"0","name":"Myanmar","name_cn":"缅甸","cover":"http://img.koubeilvxing.com/pics/img/ba/b0/bab0f5818e9788b5761e4802b768e0f4.jpg@!thumb","capitalId":0},{"id":"23427","type":"country","continentId":"32753","countryId":"0","name":"Cambodia","name_cn":"柬埔寨","cover":"http://img.koubeilvxing.com/pics/img/35/12/35126bec6c4b603bb5e5fe6decae9e71.jpg@!thumb","capitalId":0},{"id":"23428","type":"country","continentId":"32753","countryId":"0","name":"Philippines","name_cn":"菲律宾","cover":"http://img.koubeilvxing.com/pics/img/58/d7/58d7c39614b09980b293564cae9f1539.jpg@!thumb","capitalId":0},{"id":"23429","type":"country","continentId":"32753","countryId":"0","name":"Malaysia","name_cn":"马来西亚","cover":"http://img.koubeilvxing.com/pics/img/99/8c/998cf865cc02ecc14b668858b158e0e1.jpg@!thumb","capitalId":0},{"id":"30700","type":"country","continentId":"32753","countryId":"0","name":"Nepal","name_cn":"尼泊尔 ","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/f63067b3bdc4ec34eceeaa3147c6c38a.jpg@!thumb","capitalId":0},{"id":"30701","type":"country","continentId":"32753","countryId":"0","name":"Indonesia","name_cn":"印度尼西亚","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/dbf1ed2103a721509ecf69ad01c29433.jpg@!thumb","capitalId":0},{"id":"30702","type":"country","continentId":"32753","countryId":"0","name":"Vietnam","name_cn":"越南","cover":"http://img.koubeilvxing.com/pics/upload/2014-09-30/542a8737f0a3f.jpg@!thumb","capitalId":0},{"id":"32243","type":"country","continentId":"32753","countryId":"0","name":"Maldives","name_cn":"马尔代夫","cover":"http://img.koubeilvxing.com/pics/img/6f/03/6f0356665d8bd28d2da784b7fd0c6d37.jpg@!thumb","capitalId":"32760"},{"id":"32244","type":"country","continentId":"32753","countryId":"0","name":"Singapore","name_cn":"新加坡","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/5256d9e11d2ea7c9a2e5f1917614a9db.jpg@!thumb","capitalId":"32253"},{"id":"32554","type":"country","continentId":"32753","countryId":"0","name":"Hong Kong","name_cn":"香港","cover":"http://img.koubeilvxing.com/pics/upload/2014-09-30/542a835272ab5.jpg@!thumb","capitalId":"32556"},{"id":"32557","type":"country","continentId":"32753","countryId":"0","name":"Taiwan","name_cn":"台湾","cover":"http://img.koubeilvxing.com/pics/upload/2014-09-30/542a830f97c8b.jpg@!thumb","capitalId":0},{"id":"32603","type":"country","continentId":"32753","countryId":"0","name":"Macau","name_cn":"澳门","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/f8897cfb00735c585cf96c10ef456084.jpg@!thumb","capitalId":"32605"},{"id":"32762","type":"country","continentId":"32753","countryId":"0","name":"Afghanistan","name_cn":"阿富汗","cover":"http://img.koubeilvxing.com/pics/img/f7/ad/f7ad6640c9b99d43ec2acd10c0b99cf3.jpg@!thumb","capitalId":0},{"id":"32763","type":"country","continentId":"32753","countryId":"0","name":"United Arab Emirates","name_cn":"阿联酋","cover":"http://img.koubeilvxing.com/pics/img/00/8f/008f9ab8c56d6a6083a1e3b8317a3466.jpg@!thumb","capitalId":0},{"id":"32764","type":"country","continentId":"32753","countryId":"0","name":"Oman","name_cn":"阿曼","cover":"http://img.koubeilvxing.com/pics/img/36/46/364655900239fb450a21d58ba9d1471d.jpg@!thumb","capitalId":0},{"id":"32765","type":"country","continentId":"32753","countryId":"0","name":"Pakistan","name_cn":"巴基斯坦","cover":"http://img.koubeilvxing.com/pics/img/c9/0a/c90a19020ca79f9cfa2278605ff2e7e8.jpg@!thumb","capitalId":0},{"id":"32766","type":"country","continentId":"32753","countryId":"0","name":"Palestine","name_cn":"巴勒斯坦","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/c0d3c93d042a61375d29743ed4ae0947.jpg@!thumb","capitalId":0},{"id":"32767","type":"country","continentId":"32753","countryId":"0","name":"Bahrain","name_cn":"巴林","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-08/2b7cf3fe0335b7bd806bc645997c5e26.jpg@!thumb","capitalId":"32995"},{"id":"32768","type":"country","continentId":"32753","countryId":"0","name":"Bhutan","name_cn":"不丹","cover":"http://img.koubeilvxing.com/pics/img/6e/0d/6e0da38bfa8af0c33a75ef5ece8611a9.jpg@!thumb","capitalId":0},{"id":"32769","type":"country","continentId":"32753","countryId":"0","name":"North Korea","name_cn":"朝鲜","cover":"http://img.koubeilvxing.com/pics/img/8f/4d/8f4dbf09bb3987c076d7481ae07aae57.jpg@!thumb","capitalId":0},{"id":"32770","type":"country","continentId":"32753","countryId":"0","name":"East Timor","name_cn":"东帝汶","cover":"http://img.koubeilvxing.com/pics/img/71/3c/713c6369576efd233034d608f82403b1.jpg@!thumb","capitalId":0},{"id":"32771","type":"country","continentId":"32753","countryId":"0","name":"Kazakhstan","name_cn":"哈萨克斯坦","cover":"http://img.koubeilvxing.com/pics/img/ee/a9/eea9881b9a169a41cec46636e53d147a.jpg@!thumb","capitalId":0},{"id":"32772","type":"country","continentId":"32753","countryId":"0","name":"Kyrgyzstan","name_cn":"吉尔吉斯斯坦","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-08/a3dd5619e26cc9bd170bcb4059fb5fee.jpg@!thumb","capitalId":0},{"id":"32773","type":"country","continentId":"32753","countryId":"0","name":"Qatar","name_cn":"卡塔尔","cover":"http://img.koubeilvxing.com/pics/img/d8/dd/d8dd158441e7de21870077b923b8c5e9.jpg@!thumb","capitalId":"33091"},{"id":"32775","type":"country","continentId":"32753","countryId":"0","name":"Laos","name_cn":"老挝","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/16428c06effd1bed1cdadbaa1659a0ce.jpg@!thumb","capitalId":0},{"id":"32776","type":"country","continentId":"32753","countryId":"0","name":"Lebanon","name_cn":"黎巴嫩","cover":"http://img.koubeilvxing.com/pics/img/ac/f1/acf1f76f39e2a3cc91fc0cfddd9a9b3a.jpg@!thumb","capitalId":0},{"id":"32777","type":"country","continentId":"32753","countryId":"0","name":"Mongolia","name_cn":"蒙古","cover":"http://img.koubeilvxing.com/pics/upload/2015-11-23/5652e0d71fce7.jpg@!thumb","capitalId":0},{"id":"32778","type":"country","continentId":"32753","countryId":"0","name":"Bangladesh","name_cn":"孟加拉国","cover":"http://img.koubeilvxing.com/pics/upload/2015-11-23/5652de33a1e8b.jpeg@!thumb","capitalId":0},{"id":"32779","type":"country","continentId":"32753","countryId":"0","name":"Saudi Arabia","name_cn":"沙特阿拉伯","cover":"http://img.koubeilvxing.com/pics/img/7d/39/7d39477ac6ae48757cc35e964f0f079d.jpg@!thumb","capitalId":0},{"id":"32780","type":"country","continentId":"32753","countryId":"0","name":"Sri Lanka","name_cn":"斯里兰卡","cover":"http://img.koubeilvxing.com/pics/img/b5/fa/b5fa52ffecac139c07d0ae444b454d41.jpg@!thumb","capitalId":0},{"id":"32781","type":"country","continentId":"32753","countryId":"0","name":"Tajikistan","name_cn":"塔吉克斯坦","cover":"http://img.koubeilvxing.com/pics/img/75/4a/754abf5aeaa9ece5fe3b5e2032808923.jpg@!thumb","capitalId":0},{"id":"32783","type":"country","continentId":"32753","countryId":"0","name":"Brunei","name_cn":"文莱","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/6ed2af4fd38c754f0e08cdfbb6b8ab27.jpg@!thumb","capitalId":0},{"id":"32784","type":"country","continentId":"32753","countryId":"0","name":"Uzbekistan","name_cn":"乌兹别克斯坦","cover":"http://img.koubeilvxing.com/pics/img/c9/04/c904877e8c4e6f6ee32041db91290276.jpg@!thumb","capitalId":0},{"id":"32785","type":"country","continentId":"32753","countryId":"0","name":"Syria","name_cn":"叙利亚","cover":"http://img.koubeilvxing.com/pics/img/47/f3/47f39e6665eb1628ed10d0473a784312.jpg@!thumb","capitalId":0},{"id":"32786","type":"country","continentId":"32753","countryId":"0","name":"Yemen","name_cn":"也门","cover":"http://img.koubeilvxing.com/pics/img/cd/44/cd44f2f2ea900093dc4b3a30afaf334c.jpg@!thumb","capitalId":0},{"id":"32787","type":"country","continentId":"32753","countryId":"0","name":"Iraq","name_cn":"伊拉克","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/399962211f20a8c4e43cfbf60c70a8ce.jpg@!thumb","capitalId":0},{"id":"32788","type":"country","continentId":"32753","countryId":"0","name":"Iran","name_cn":"伊朗","cover":"http://img.koubeilvxing.com/pics/img/d7/4e/d74e8613949a1f4ad2ae56312cb8ffb5.jpg@!thumb","capitalId":0},{"id":"32789","type":"country","continentId":"32753","countryId":"0","name":"British Indian Ocean Territory","name_cn":"英属印度洋领地","cover":"http://img.koubeilvxing.com/pics/upload/2014-12-05/82063a6806a7031bfc61f65e63a16a2b.jpg@!thumb","capitalId":"33481"},{"id":"32790","type":"country","continentId":"32753","countryId":"0","name":"Israel","name_cn":"以色列","cover":"http://img.koubeilvxing.com/pics/img/44/97/4497c14353bb7366654e173f1fb8cdca.jpg@!thumb","capitalId":0},{"id":"32791","type":"country","continentId":"32753","countryId":"0","name":"Jordan","name_cn":"约旦","cover":"http://img.koubeilvxing.com/pics/img/b4/d2/b4d245b2fafa4cec9980c1085d914082.jpg@!thumb","capitalId":0}]
     */

    private List<ContinentsBean> continents;
    /**
     * id : 326
     * name : Bangkok
     * name_cn : 曼谷
     * cover : http://img.koubeilvxing.com/pics/upload/2015-07-28/55b6d992efaed.jpg@!thumb
     * desc : 佛教之都，包罗万象
     * info_cn :
     * info :
     */

    private List<RecommendplacesBean> recommendplaces;

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public List<ContinentsBean> getContinents() {
        return continents;
    }

    public void setContinents(List<ContinentsBean> continents) {
        this.continents = continents;
    }

    public List<RecommendplacesBean> getRecommendplaces() {
        return recommendplaces;
    }

    public void setRecommendplaces(List<RecommendplacesBean> recommendplaces) {
        this.recommendplaces = recommendplaces;
    }

    public static class ContinentsBean {
        private String id;
        private String type;
        private String continentId;
        private String countryId;
        private String name;
        private String name_cn;
        private String cover;
        private String path;
        /**
         * id : 1
         * type : country
         * continentId : 32753
         * countryId : 0
         * name : Thailand
         * name_cn : 泰国
         * cover : http://img.koubeilvxing.com/pics/upload/2015-07-28/55b6d992efaed.jpg@!thumb
         * capitalId : 0
         */

        private List<CountrysBean> countrys;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getContinentId() {
            return continentId;
        }

        public void setContinentId(String continentId) {
            this.continentId = continentId;
        }

        public String getCountryId() {
            return countryId;
        }

        public void setCountryId(String countryId) {
            this.countryId = countryId;
        }

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

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public List<CountrysBean> getCountrys() {
            return countrys;
        }

        public void setCountrys(List<CountrysBean> countrys) {
            this.countrys = countrys;
        }

        public static class CountrysBean {
            private String id;
            private String type;
            private String continentId;
            private String countryId;
            private String name;
            private String name_cn;
            private String cover;
            private int capitalId;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getContinentId() {
                return continentId;
            }

            public void setContinentId(String continentId) {
                this.continentId = continentId;
            }

            public String getCountryId() {
                return countryId;
            }

            public void setCountryId(String countryId) {
                this.countryId = countryId;
            }

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

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public int getCapitalId() {
                return capitalId;
            }

            public void setCapitalId(int capitalId) {
                this.capitalId = capitalId;
            }
        }
    }

    public static class RecommendplacesBean {
        private String id;
        private String name;
        private String name_cn;
        private String cover;
        private String desc;
        private String info_cn;
        private String info;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

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

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getInfo_cn() {
            return info_cn;
        }

        public void setInfo_cn(String info_cn) {
            this.info_cn = info_cn;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }
}
