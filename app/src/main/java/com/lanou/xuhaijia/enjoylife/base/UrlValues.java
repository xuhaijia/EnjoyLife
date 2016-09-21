package com.lanou.xuhaijia.enjoylife.base;

/**
 * Created by 徐海佳 on 16/9/13.
 */
public final class UrlValues {

    // 音乐
    public static final String MUSIC_HOT_SINGLE = "https://music.douban.com/api/artist/chart?type=song&cb=%24.setp(0.45684256171807647)&app_name=music_artist&version=52&user_id=150964751&token=6fc4214eea&expire=1489024922&_=1473475059075";
    public static final String MUSIC_HOT_MUSICIAN = "https://music.douban.com/api/artist/chart?type=artist&cb=%24.setp(0.11327802087180316)&app_name=music_artist&version=52&user_id=150964751&token=6fc4214eea&expire=1489024922&_=1473475059081";
    public static final String MUSIC_TYPE_SEARCH = "https://music.douban.com/api/artist/search?q=%25E6%2588%2591&cb=%24.setp(0.9167326588649303)&app_name=music_artist&version=52&user_id=150964751&token=6fc4214eea&expire=1489024922&_=1473475059085";

    public static final String MUSIC_SEARCH_BYID_START = "https://music.douban.com/api/artist/genre?gid=";
    public static final String MUSIC_SEARCH_BYID_END = "&type=artist&sortby=hot&cb=%24.setp(0.9941302437800914)&app_name=music_artist&version=52&_=1474264683933";

    public static final String MUSIC_SEARCH_START = "https://music.douban.com/api/artist/search?q=";
    public static final String MUSIC_SEARCH_END = "&cb=%24.setp(0.3023930210620165)&app_name=music_artist&version=52&_=1474264683937";

    public static final String MUSIC_CARE_ACTIVITY_START = "https://music.douban.com/api/artist/artist_event?id=";
    public static final String MUSIC_CARE_ACTIVITY_END = "&cb=%24.setp(0.4713750318624079)&app_name=music_artist&version=52&token=6fc4214eea&expire=1489024922&_=1473475059104";

    public static final String MUSIC_CARE_PHOTO_START = "https://music.douban.com/api/artist/artist_album?id=";
    public static final String MUSIC_CARE_PHOTO_END = "&cb=%24.setp(0.24206765461713076)&app_name=music_artist&version=52&user_id=150964751&token=6fc4214eea&expire=1489024922&_=1473475059116";

    public static final String MUSIC_CARE_MESSAGE_START = "https://music.douban.com/api/artist/artist_board?id=";
    public static final String MUSIC_CARE_MESSAGE_END = "&cb=%24.setp(0.2982795466668904)&app_name=music_artist&version=52&user_id=150964751&token=6fc4214eea&expire=1489024922&_=1473475059117";

    public static final String MUSIC_CARE_SONGS_START = "https://music.douban.com/api/artist/artist_playlist?id=";
    public static final String MUSIC_CARE_SONGS_END = "&cb=%24.setp(0.5162793209310621)&app_name=music_artist&version=52&user_id=150964751&token=6fc4214eea&expire=1489024922&_=1473487579154";

    public static final String MUSIC_SONGS_IN_START = "https://music.douban.com/api/artist/songs?id=";
    public static final String MUSIC_SONGS_IN_END = "&cb=%24.setp(0.09684648201800883)&app_name=music_artist&version=52&user_id=150964751&token=6fc4214eea&expire=1489024922&_=1473487579158";

    public static final String MUSIC_PHOTO_IN_START = "https://music.douban.com/api/artist/photos?id=";
    public static final String MUSIC_PHOTO_IN_END = "&cate=albumcover&limit=15&cb=%24.setp(0.628224239917472)&app_name=music_artist&version=52&user_id=150964751&token=f8606041e9&expire=1489830153&_=1474283196468";


    // 新闻
    public static final String NEWS_HEADLINE = "http://c.3g.163.com/nc/article/headline/T1348647909107/0-20.html";
    public static final String NEWS_PE = "http://c.3g.163.com/nc/article/list/T1348649079062/0-20.html";
    public static final String NEWS_RECREATION = "http://c.3g.163.com/nc/article/list/T1348648517839/0-20.html";
    public static final String NEWS_YULE_FRONT = "";
    public static final String NEWS_YULE_BEHIND = "";


    // 旅行
    //先给一个网址 景点的初始化
    public static final String TRAVEL_IMGER_INITALIZE = "http://www.koubeilvxing.com/placeinfo?lang=zh&placeId=32556";

    public static final String TRAVEL_ATTRACTIONS = "http://www.koubeilvxing.com/search?lang=zh&lat=0.000000&lng=0.000000&module=attraction&page=1&placeId=32556&rows=10";
    //选择城市的URL
    public static final String TRAVEL_CITY_SELECT = "http://www.koubeilvxing.com/countrys?lang=zh";

    // 画报
    public static final String PICTURE_ALL_URL = "http://design.zuimeia.com/api/v1/articles/daily/simple/?app_version=2.2.4&device_id=086b6e6707d0ef6f3656d1a3621894b23c350107&device_name=iPhone&package_name=com.zuimeia.ZUIRanking&page=1&page_size=20&platform=iphone&resolution=%7B750%2C%201334%7D&system_version=9.3.3";
    public static final String PIVTURE_DETAILS_STAER_URL = "http://design.zuimeia.com/api/v1/article/";
    public static final String PIVTURE_DETAILS_END_URL = "/?app_version=2.2.4&device_id=086b6e6707d0ef6f3656d1a3621894b23c350107&device_name=iPhone&package_name=com.zuimeia.ZUIRanking&platform=iphone&resolution=%7B750%2C%201334%7D&system_version=9.3.3";

    // 福利


}
