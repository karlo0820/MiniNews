package com.jiale.mininews.apis;

import static android.os.Build.HOST;

/**
 * Created by Karlo on 2016/12/12.
 */

public class ApiConstans {
    public static final int FIRST = 0;
    public static final int MORE = 1;
    public static final int REFRESH = 2;
    public static final String API_ID = "api_id";
    public static final int TYPE_NETEASE = 0;
    public static final int TYPE_PHOTO = 1;
    /*网易HOST*/
    public static final String HOST_NETEASE = "http://c.m.163.com/";
    //头条TYPE
    public static final String NETEASE_TYPE_HEADLINE = "headline";
    //房产TYPE
    public static final String NETEASE_TYPE_HOUSE = "house";
    //其他TYPE
    public static final String NETEASE_TYPE_OTHER = "list";
    /**
     * 请求
     *
     * example：http://c.m.163.com/nc/article/headline/T1348647909107/0-20.html
     *
     * example：http://c.m.163.com/nc/article/BG6CGA9M00264N2N/full.html
     *
     * @param newsType ：headline为头条,house为房产，list为其他
     *
     *   /photo/api/set/0001/2220607.json photoset图片集
     *
     *
     */
    /**
     * --------------------------  ID ------------------------------
     **/
    //要闻
    public static final String NETEASE_ID_HEADLINE = "T1348647909107";
    // 房产id http://c.m.163.com/nc/article/house/5YyX5Lqs/0-20.html
    public static final String NETEASE_ID_HOUSE = "5YyX5Lqs";
    //体育
    public static final String NETEASE_ID_SPORTS = "T1348649079062";
    //娱乐 http://c.m.163.com/nc/article/list/T1348648517839/0-20.html
    public static final String NETEASE_ID_ENTERTAINMENT = "T1348648517839";
    //财经
    public static final String NETEASE_ID_FINANCE = "T1348648756099";
    //科技
    public static final String NETEASE_ID_TECH = "T1348649580692";
    //电影
    public static final String NETEASE_ID_MOVIE = "T1348648650048";
    //汽车
    public static final String NETEASE_ID_CAR = "T1348654060988";
    //笑话
    public static final String NETEASE_ID_JOKE = "T1350383429665";
    //游戏
    public static final String NETEASE_ID_GAME = "T1348654151579";
    //时尚
    public static final String NETEASE_ID_FASHION = "T1348650593803";
    //情感 http://c.m.163.com/nc/article/list/T1348650839000/0-20.html
    public static final String NETEASE_ID_EMOTION = "T1348650839000";
    //精选
    public static final String NETEASE_ID_CHOICE = "T1370583240249";
    //电台
    public static final String NETEASE_ID_RADIO = "T1379038288239";
    //NBA
    public static final String NETEASE_ID_NAB = "T1348649145984";
    //数码
    public static final String NETEASE_ID_DIGITAL = "T1348649776727";
    //移动
    public static final String NETEASE_ID_MOBILE = "T1351233117091";
    //彩票
    public static final String NETEASE_ID_LOTTERY = "T1356600029035";
    //教育
    public static final String NETEASE_ID_EDUCATION = "T1348654225495";

    //论坛
    public static final String NETEASE_ID_FORUM = "T1349837670307";

    //旅游
    public static final String NETEASE_ID_TOUR = "T1348654204705";

    //手机 http://c.m.163.com/nc/article/list/T1348649654285/0-20.html
    public static final String NETEASE_ID_PHONE = "T1348649654285";

    //博客 http://c.m.163.com/nc/article/list/T1349837698345/0-20.html
    public static final String NETEASE_ID_BLOG = "T1349837698345";

    //社会http://c.m.163.com/nc/article/list/T1348648037603/0-20.html
    public static final String NETEASE_ID_SOCIETY = "T1348648037603";

    //家居 http://c.m.163.com/nc/article/list/T1348654105308/0-20.html
    public static final String NETEASE_ID_FURNISHING = "T1348654105308";

    //军事
    public static final String NETEASE_ID_MILITARY = "T1348648141035";
    /* 图片HOST
    * http://gank.io/api/data/福利/{count}/{page}
    * http://gank.io/api/data/福利/20/2
    * */
    public static final String HOST_PHOTO = "http://gank.io/api/";

    public static String getHost(int hostType) throws Throwable {
        switch (hostType) {
            case TYPE_NETEASE: {
                return HOST_NETEASE;
            }
            case TYPE_PHOTO: {
                return HOST_PHOTO;
            }
            default:
                throw new Throwable("not such Type Host,please check your request Host!");
        }
    }

    public static String getTypeById(String Id) {
        switch (Id) {
            case NETEASE_ID_HEADLINE: {
                return NETEASE_TYPE_HEADLINE;
            }
            case NETEASE_ID_HOUSE: {
                return NETEASE_TYPE_HOUSE;
            }
        }
        return NETEASE_TYPE_OTHER;
    }
}
