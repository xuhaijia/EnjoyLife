package com.lanou.xuhaijia.enjoylife.travel.food.foodlist;/*
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
 * Created by 常久青 on 16/9/26.
 */

import java.util.List;

public class FoodListAtyBean {

    public static final String TAG = "TAG_FoodListAtyBean";

    /**
     * ret : 1
     * item : {"id":"1215071","countryId":"23131","cityId":"23261","name":"Ichiran, Shibuya","name_cn":"一兰拉面(涩谷店)","lat":"35.661118","lng":"139.70108","address":"1-22-7 Jinnan | Iwamoto Bldg. B1F, Shibuya, Tokyo Prefecture 150-0041, Japan","contact":"+81 3 3463 3667","cover":"http://img.koubeilvxing.com/pics/2014/12/04/cc4574307fae58837a5bfd1ba5d72d71.jpg@!common","path":"/2014/12/04/cc4574307fae58837a5bfd1ba5d72d71.jpg","coverPhotoId":"0","price":"56","score":"9","overall":"0.714","reviewCount":"591","positiveReviewCount":"535","neutralReviewCount":"46","negativeReviewCount":"10","info":"在东京有多家连锁店，是来自九州的豚骨拉面。点餐时可以按自己的口味选择汤的味道和面的软硬。是一家地道的日本拉面馆，在东京有多家分店。","info_cn":"在东京有多家连锁店，是来自九州的豚骨拉面。点餐时可以按自己的口味选择汤的味道和面的软硬。是一家地道的日本拉面馆，在东京有多家分店。","status":"1","opening_time":"","tip":"","traffic":"JR涉谷站（八公口出）　步行3分钟東京地铁银座线　涉谷站出站后　步行3分钟東京地铁半藏门线　涉谷站　步行3分钟","priceinfo":"价格： ¥49 - ¥62","cuisines":"","tag":"Breakfast,Late Night","tag_cn":"早餐,夜宵","cuisines_cn":"","menus":[],"menuCount":"0","dimensionScores":[{"tag":"taste","name":"口味","score":"6.48113"},{"tag":"service","name":"服务","score":"6.03938"},{"tag":"price","name":"性价比","score":"7.84607"},{"tag":"atmosphere","name":"氛围","score":"6.48473"}],"photoCount":"0","sites":[],"reviews":[{"id":"58165562","restaurantId":"1215071","feedId":"1591760","siteId":"0","siteName":"tripadvisor","author":"Livlim12","location":"","time":"2015-08-18 00:00:00","cTime":"2015-08-28 21:29:33","price":"0","score":"10","userface":"http://ccm.ddcdn.com/photo-f/02/88/d5/53/daodaoavatar011.jpg","score_food":"0","score_service":"0","score_atmosphere":"0","title":"","pros":"","cons":"","comment":"超级好吃 但路痴去了两次才找到 \r\n涩谷站出去后根本就是迷宫 身为路痴的话第一次的时候没找到 第二次才根据非常详细的指示找到了餐厅 和一般的拉面店一样都是通过自动点券机进行购买 然后坐在隔间品尝 我还买了快熟面回去给家人 只是味道跟餐厅差很远","author_cn":"","title_cn":"","comment_cn":"","translate":"1","siteRank":1},{"id":"58165563","restaurantId":"1215071","feedId":"1591760","siteId":"0","siteName":"tripadvisor","author":"_H5685VZ","location":"桃园县","time":"2015-08-06 00:00:00","cTime":"2015-08-28 21:29:33","price":"0","score":"10","userface":"http://ccm.ddcdn.com/ext/photo-f/01/2a/fd/8d/avatar.jpg","score_food":"0","score_service":"0","score_atmosphere":"0","title":"","pros":"","cons":"","comment":"就是好吃~ \r\n在日本吃过一兰拉面好几次, 涩谷这家一兰拉面当然也是要来试试, 果然依旧是相同品质! 赞喔!\r\n因为人多, 有时后需要排队!","author_cn":"","title_cn":"","comment_cn":"","translate":"1","siteRank":1},{"id":"58165564","restaurantId":"1215071","feedId":"1591760","siteId":"0","siteName":"tripadvisor","author":"feng515","location":"","time":"2015-05-05 00:00:00","cTime":"2015-08-28 21:29:33","price":"0","score":"10","userface":"http://ccm.ddcdn.com/photo-f/02/88/d5/8e/daodaoavatar070.jpg","score_food":"0","score_service":"0","score_atmosphere":"0","title":"","pros":"","cons":"","comment":"味道很赞 \r\n听朋友说是日本最有名的拉面，就跑到涉谷去尝了一下。和一般的拉面店一样都是通过自动点券机进行购买，面的硬度，汤的浓度，葱花的种类等，最奇特的地方就是用隔板挡开，据说这样可以更加集中来吃。味道很赞。","author_cn":"","title_cn":"","comment_cn":"","translate":"1","siteRank":1}],"covermore":"","parent":"东京,日本","cityName":"东京","countryName":"日本","reservable":0,"favoured":0,"hotelCount":"1121","restaurantCount":"45832","attractionCount":"935","shoppingCount":"346","activityCount":"254"}
     */

    private int ret;
    /**
     * id : 1215071
     * countryId : 23131
     * cityId : 23261
     * name : Ichiran, Shibuya
     * name_cn : 一兰拉面(涩谷店)
     * lat : 35.661118
     * lng : 139.70108
     * address : 1-22-7 Jinnan | Iwamoto Bldg. B1F, Shibuya, Tokyo Prefecture 150-0041, Japan
     * contact : +81 3 3463 3667
     * cover : http://img.koubeilvxing.com/pics/2014/12/04/cc4574307fae58837a5bfd1ba5d72d71.jpg@!common
     * path : /2014/12/04/cc4574307fae58837a5bfd1ba5d72d71.jpg
     * coverPhotoId : 0
     * price : 56
     * score : 9
     * overall : 0.714
     * reviewCount : 591
     * positiveReviewCount : 535
     * neutralReviewCount : 46
     * negativeReviewCount : 10
     * info : 在东京有多家连锁店，是来自九州的豚骨拉面。点餐时可以按自己的口味选择汤的味道和面的软硬。是一家地道的日本拉面馆，在东京有多家分店。
     * info_cn : 在东京有多家连锁店，是来自九州的豚骨拉面。点餐时可以按自己的口味选择汤的味道和面的软硬。是一家地道的日本拉面馆，在东京有多家分店。
     * status : 1
     * opening_time :
     * tip :
     * traffic : JR涉谷站（八公口出）　步行3分钟東京地铁银座线　涉谷站出站后　步行3分钟東京地铁半藏门线　涉谷站　步行3分钟
     * priceinfo : 价格： ¥49 - ¥62
     * cuisines :
     * tag : Breakfast,Late Night
     * tag_cn : 早餐,夜宵
     * cuisines_cn :
     * menus : []
     * menuCount : 0
     * dimensionScores : [{"tag":"taste","name":"口味","score":"6.48113"},{"tag":"service","name":"服务","score":"6.03938"},{"tag":"price","name":"性价比","score":"7.84607"},{"tag":"atmosphere","name":"氛围","score":"6.48473"}]
     * photoCount : 0
     * sites : []
     * reviews : [{"id":"58165562","restaurantId":"1215071","feedId":"1591760","siteId":"0","siteName":"tripadvisor","author":"Livlim12","location":"","time":"2015-08-18 00:00:00","cTime":"2015-08-28 21:29:33","price":"0","score":"10","userface":"http://ccm.ddcdn.com/photo-f/02/88/d5/53/daodaoavatar011.jpg","score_food":"0","score_service":"0","score_atmosphere":"0","title":"","pros":"","cons":"","comment":"超级好吃 但路痴去了两次才找到 \r\n涩谷站出去后根本就是迷宫 身为路痴的话第一次的时候没找到 第二次才根据非常详细的指示找到了餐厅 和一般的拉面店一样都是通过自动点券机进行购买 然后坐在隔间品尝 我还买了快熟面回去给家人 只是味道跟餐厅差很远","author_cn":"","title_cn":"","comment_cn":"","translate":"1","siteRank":1},{"id":"58165563","restaurantId":"1215071","feedId":"1591760","siteId":"0","siteName":"tripadvisor","author":"_H5685VZ","location":"桃园县","time":"2015-08-06 00:00:00","cTime":"2015-08-28 21:29:33","price":"0","score":"10","userface":"http://ccm.ddcdn.com/ext/photo-f/01/2a/fd/8d/avatar.jpg","score_food":"0","score_service":"0","score_atmosphere":"0","title":"","pros":"","cons":"","comment":"就是好吃~ \r\n在日本吃过一兰拉面好几次, 涩谷这家一兰拉面当然也是要来试试, 果然依旧是相同品质! 赞喔!\r\n因为人多, 有时后需要排队!","author_cn":"","title_cn":"","comment_cn":"","translate":"1","siteRank":1},{"id":"58165564","restaurantId":"1215071","feedId":"1591760","siteId":"0","siteName":"tripadvisor","author":"feng515","location":"","time":"2015-05-05 00:00:00","cTime":"2015-08-28 21:29:33","price":"0","score":"10","userface":"http://ccm.ddcdn.com/photo-f/02/88/d5/8e/daodaoavatar070.jpg","score_food":"0","score_service":"0","score_atmosphere":"0","title":"","pros":"","cons":"","comment":"味道很赞 \r\n听朋友说是日本最有名的拉面，就跑到涉谷去尝了一下。和一般的拉面店一样都是通过自动点券机进行购买，面的硬度，汤的浓度，葱花的种类等，最奇特的地方就是用隔板挡开，据说这样可以更加集中来吃。味道很赞。","author_cn":"","title_cn":"","comment_cn":"","translate":"1","siteRank":1}]
     * covermore :
     * parent : 东京,日本
     * cityName : 东京
     * countryName : 日本
     * reservable : 0
     * favoured : 0
     * hotelCount : 1121
     * restaurantCount : 45832
     * attractionCount : 935
     * shoppingCount : 346
     * activityCount : 254
     */

    private ItemBean item;

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public ItemBean getItem() {
        return item;
    }

    public void setItem(ItemBean item) {
        this.item = item;
    }

    public static class ItemBean {
        private String id;
        private String countryId;
        private String cityId;
        private String name;
        private String name_cn;
        private String lat;
        private String lng;
        private String address;
        private String contact;
        private String cover;
        private String path;
        private String coverPhotoId;
        private String price;
        private String score;
        private String overall;
        private String reviewCount;
        private String positiveReviewCount;
        private String neutralReviewCount;
        private String negativeReviewCount;
        private String info;
        private String info_cn;
        private String status;
        private String opening_time;
        private String tip;
        private String traffic;
        private String priceinfo;
        private String cuisines;
        private String tag;
        private String tag_cn;
        private String cuisines_cn;
        private String menuCount;
        private String photoCount;
        private String covermore;
        private String parent;
        private String cityName;
        private String countryName;
        private int reservable;
        private int favoured;
        private String hotelCount;
        private String restaurantCount;
        private String attractionCount;
        private String shoppingCount;
        private String activityCount;
        private List<?> menus;
        /**
         * tag : taste
         * name : 口味
         * score : 6.48113
         */

        private List<DimensionScoresBean> dimensionScores;
        private List<?> sites;
        /**
         * id : 58165562
         * restaurantId : 1215071
         * feedId : 1591760
         * siteId : 0
         * siteName : tripadvisor
         * author : Livlim12
         * location :
         * time : 2015-08-18 00:00:00
         * cTime : 2015-08-28 21:29:33
         * price : 0
         * score : 10
         * userface : http://ccm.ddcdn.com/photo-f/02/88/d5/53/daodaoavatar011.jpg
         * score_food : 0
         * score_service : 0
         * score_atmosphere : 0
         * title :
         * pros :
         * cons :
         * comment : 超级好吃 但路痴去了两次才找到
         涩谷站出去后根本就是迷宫 身为路痴的话第一次的时候没找到 第二次才根据非常详细的指示找到了餐厅 和一般的拉面店一样都是通过自动点券机进行购买 然后坐在隔间品尝 我还买了快熟面回去给家人 只是味道跟餐厅差很远
         * author_cn :
         * title_cn :
         * comment_cn :
         * translate : 1
         * siteRank : 1
         */

        private List<ReviewsBean> reviews;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCountryId() {
            return countryId;
        }

        public void setCountryId(String countryId) {
            this.countryId = countryId;
        }

        public String getCityId() {
            return cityId;
        }

        public void setCityId(String cityId) {
            this.cityId = cityId;
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

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getContact() {
            return contact;
        }

        public void setContact(String contact) {
            this.contact = contact;
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

        public String getCoverPhotoId() {
            return coverPhotoId;
        }

        public void setCoverPhotoId(String coverPhotoId) {
            this.coverPhotoId = coverPhotoId;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public String getOverall() {
            return overall;
        }

        public void setOverall(String overall) {
            this.overall = overall;
        }

        public String getReviewCount() {
            return reviewCount;
        }

        public void setReviewCount(String reviewCount) {
            this.reviewCount = reviewCount;
        }

        public String getPositiveReviewCount() {
            return positiveReviewCount;
        }

        public void setPositiveReviewCount(String positiveReviewCount) {
            this.positiveReviewCount = positiveReviewCount;
        }

        public String getNeutralReviewCount() {
            return neutralReviewCount;
        }

        public void setNeutralReviewCount(String neutralReviewCount) {
            this.neutralReviewCount = neutralReviewCount;
        }

        public String getNegativeReviewCount() {
            return negativeReviewCount;
        }

        public void setNegativeReviewCount(String negativeReviewCount) {
            this.negativeReviewCount = negativeReviewCount;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getInfo_cn() {
            return info_cn;
        }

        public void setInfo_cn(String info_cn) {
            this.info_cn = info_cn;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getOpening_time() {
            return opening_time;
        }

        public void setOpening_time(String opening_time) {
            this.opening_time = opening_time;
        }

        public String getTip() {
            return tip;
        }

        public void setTip(String tip) {
            this.tip = tip;
        }

        public String getTraffic() {
            return traffic;
        }

        public void setTraffic(String traffic) {
            this.traffic = traffic;
        }

        public String getPriceinfo() {
            return priceinfo;
        }

        public void setPriceinfo(String priceinfo) {
            this.priceinfo = priceinfo;
        }

        public String getCuisines() {
            return cuisines;
        }

        public void setCuisines(String cuisines) {
            this.cuisines = cuisines;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getTag_cn() {
            return tag_cn;
        }

        public void setTag_cn(String tag_cn) {
            this.tag_cn = tag_cn;
        }

        public String getCuisines_cn() {
            return cuisines_cn;
        }

        public void setCuisines_cn(String cuisines_cn) {
            this.cuisines_cn = cuisines_cn;
        }

        public String getMenuCount() {
            return menuCount;
        }

        public void setMenuCount(String menuCount) {
            this.menuCount = menuCount;
        }

        public String getPhotoCount() {
            return photoCount;
        }

        public void setPhotoCount(String photoCount) {
            this.photoCount = photoCount;
        }

        public String getCovermore() {
            return covermore;
        }

        public void setCovermore(String covermore) {
            this.covermore = covermore;
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

        public String getCountryName() {
            return countryName;
        }

        public void setCountryName(String countryName) {
            this.countryName = countryName;
        }

        public int getReservable() {
            return reservable;
        }

        public void setReservable(int reservable) {
            this.reservable = reservable;
        }

        public int getFavoured() {
            return favoured;
        }

        public void setFavoured(int favoured) {
            this.favoured = favoured;
        }

        public String getHotelCount() {
            return hotelCount;
        }

        public void setHotelCount(String hotelCount) {
            this.hotelCount = hotelCount;
        }

        public String getRestaurantCount() {
            return restaurantCount;
        }

        public void setRestaurantCount(String restaurantCount) {
            this.restaurantCount = restaurantCount;
        }

        public String getAttractionCount() {
            return attractionCount;
        }

        public void setAttractionCount(String attractionCount) {
            this.attractionCount = attractionCount;
        }

        public String getShoppingCount() {
            return shoppingCount;
        }

        public void setShoppingCount(String shoppingCount) {
            this.shoppingCount = shoppingCount;
        }

        public String getActivityCount() {
            return activityCount;
        }

        public void setActivityCount(String activityCount) {
            this.activityCount = activityCount;
        }

        public List<?> getMenus() {
            return menus;
        }

        public void setMenus(List<?> menus) {
            this.menus = menus;
        }

        public List<DimensionScoresBean> getDimensionScores() {
            return dimensionScores;
        }

        public void setDimensionScores(List<DimensionScoresBean> dimensionScores) {
            this.dimensionScores = dimensionScores;
        }

        public List<?> getSites() {
            return sites;
        }

        public void setSites(List<?> sites) {
            this.sites = sites;
        }

        public List<ReviewsBean> getReviews() {
            return reviews;
        }

        public void setReviews(List<ReviewsBean> reviews) {
            this.reviews = reviews;
        }

        public static class DimensionScoresBean {
            private String tag;
            private String name;
            private String score;

            public String getTag() {
                return tag;
            }

            public void setTag(String tag) {
                this.tag = tag;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getScore() {
                return score;
            }

            public void setScore(String score) {
                this.score = score;
            }
        }

        public static class ReviewsBean {
            private String id;
            private String restaurantId;
            private String feedId;
            private String siteId;
            private String siteName;
            private String author;
            private String location;
            private String time;
            private String cTime;
            private String price;
            private String score;
            private String userface;
            private String score_food;
            private String score_service;
            private String score_atmosphere;
            private String title;
            private String pros;
            private String cons;
            private String comment;
            private String author_cn;
            private String title_cn;
            private String comment_cn;
            private String translate;
            private int siteRank;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getRestaurantId() {
                return restaurantId;
            }

            public void setRestaurantId(String restaurantId) {
                this.restaurantId = restaurantId;
            }

            public String getFeedId() {
                return feedId;
            }

            public void setFeedId(String feedId) {
                this.feedId = feedId;
            }

            public String getSiteId() {
                return siteId;
            }

            public void setSiteId(String siteId) {
                this.siteId = siteId;
            }

            public String getSiteName() {
                return siteName;
            }

            public void setSiteName(String siteName) {
                this.siteName = siteName;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getCTime() {
                return cTime;
            }

            public void setCTime(String cTime) {
                this.cTime = cTime;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getScore() {
                return score;
            }

            public void setScore(String score) {
                this.score = score;
            }

            public String getUserface() {
                return userface;
            }

            public void setUserface(String userface) {
                this.userface = userface;
            }

            public String getScore_food() {
                return score_food;
            }

            public void setScore_food(String score_food) {
                this.score_food = score_food;
            }

            public String getScore_service() {
                return score_service;
            }

            public void setScore_service(String score_service) {
                this.score_service = score_service;
            }

            public String getScore_atmosphere() {
                return score_atmosphere;
            }

            public void setScore_atmosphere(String score_atmosphere) {
                this.score_atmosphere = score_atmosphere;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getPros() {
                return pros;
            }

            public void setPros(String pros) {
                this.pros = pros;
            }

            public String getCons() {
                return cons;
            }

            public void setCons(String cons) {
                this.cons = cons;
            }

            public String getComment() {
                return comment;
            }

            public void setComment(String comment) {
                this.comment = comment;
            }

            public String getAuthor_cn() {
                return author_cn;
            }

            public void setAuthor_cn(String author_cn) {
                this.author_cn = author_cn;
            }

            public String getTitle_cn() {
                return title_cn;
            }

            public void setTitle_cn(String title_cn) {
                this.title_cn = title_cn;
            }

            public String getComment_cn() {
                return comment_cn;
            }

            public void setComment_cn(String comment_cn) {
                this.comment_cn = comment_cn;
            }

            public String getTranslate() {
                return translate;
            }

            public void setTranslate(String translate) {
                this.translate = translate;
            }

            public int getSiteRank() {
                return siteRank;
            }

            public void setSiteRank(int siteRank) {
                this.siteRank = siteRank;
            }
        }
    }
}
