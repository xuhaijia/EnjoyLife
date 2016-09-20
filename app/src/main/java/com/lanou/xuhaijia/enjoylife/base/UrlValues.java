package com.lanou.xuhaijia.enjoylife.base;

/**
 * Created by 徐海佳 on 16/9/13.
 */
public final class UrlValues {

    // 音乐
    public static final String MUSIC_HOT_SINGLE = "https://music.douban.com/api/artist/chart?type=song&cb=%24.setp(0.45684256171807647)&app_name=music_artist&version=52&user_id=150964751&token=6fc4214eea&expire=1489024922&_=1473475059075";
    public static final String MUSIC_HOT_MUSICIAN = "https://music.douban.com/api/artist/chart?type=artist&cb=%24.setp(0.11327802087180316)&app_name=music_artist&version=52&user_id=150964751&token=6fc4214eea&expire=1489024922&_=1473475059081";
    public static final String MUSIC_TYPE_SEARCH = "https://music.douban.com/api/artist/search?q=&cb=%24.setp(0.6899591605179012)&app_name=music_artist&version=52&user_id=150964751&token=6fc4214eea&expire=1489024922&_=1473475059076";

    public static final String MUSIC_CARE_ACTIVITY_START = "https://music.douban.com/api/artist/artist_event?id=";
    public static final String MUSIC_CARE_ACTIVITY_END = "&cb=%24.setp(0.4713750318624079)&app_name=music_artist&version=52&token=6fc4214eea&expire=1489024922&_=1473475059104";


    public static final String MUSIC_CARE_TRENDS_START = "https://music.douban.com/api/artist/artist_update?id=";
    public static final String MUSIC_CARE_TRENDS_END = "&cb=%24.setp(0.6893533570691943)&app_name=music_artist&version=52&user_id=150964751&token=6fc4214eea&expire=1489024922&_=1473475059109";

    public static final String MUSIC_CARE_PHOTO_START = "https://music.douban.com/api/artist/artist_album?id=";
    public static final String MUSIC_CARE_PHOTO_END = "&cb=%24.setp(0.24206765461713076)&app_name=music_artist&version=52&user_id=150964751&token=6fc4214eea&expire=1489024922&_=1473475059116";

    public static final String MUSIC_CARE_MESSAGE_START = "https://music.douban.com/api/artist/artist_board?id=";
    public static final String MUSIC_CARE_MESSAGE_END = "&cb=%24.setp(0.2982795466668904)&app_name=music_artist&version=52&user_id=150964751&token=6fc4214eea&expire=1489024922&_=1473475059117";

    public static final String MUSIC_CARE_SONG_START = "https://music.douban.com/api/artist/artist_playlist?id=";
    public static final String MUSIC_CARE_SONG_END = "&cb=%24.setp(0.5162793209310621)&app_name=music_artist&version=52&user_id=150964751&token=6fc4214eea&expire=1489024922&_=1473487579154";


    // 新闻
    public static final String NEWS_HEADLINE = "http://c.3g.163.com/nc/article/headline/T1348647909107/0-20.html";
    public static final String NEWS_PE = "http://c.3g.163.com/nc/article/list/T1348649079062/0-20.html";
    public static final String NEWS_RECREATION = "http://c.3g.163.com/nc/article/list/T1348648517839/0-20.html";
    public static final String NEWS_FRONT = "http://3g.163.com/touch/photoview.html?channel=ent&child=all&qd=pc_adaptation&offset=";
    public static final String NEWS_between = "&setid=";
    public static final String NEWS_BEHIND = "&channelid=";


    // 旅行
    //先给一个网址 景点的初始化
    public static final String TRAVEL_IMGER_INITALIZE = "http://www.koubeilvxing.com/placeinfo?lang=zh&placeId=32556";

    public static final String TRAVEL_ATTRACTIONS = "http://www.koubeilvxing.com/search?lang=zh&lat=0.000000&lng=0.000000&module=attraction&page=1&placeId=32556&rows=10";
    //选择城市的URL
    public static final String TRAVEL_CITY_SELECT = "http://www.koubeilvxing.com/countrys?lang=zh";

    // 画报
    public static final String PICTURE_ALL_URL = "http://design.zuimeia.com/api/v1/articles/daily/simple/?";


    // 福利


}
