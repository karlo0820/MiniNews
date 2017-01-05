package com.jiale.mininews.bean;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Karlo on 2016/12/12.
 */

public class NewsBean {
    private int type;
    private String postid;
    private boolean hasCover;
    private int hasHead;
    private int replyCount;
    private int hasImg;
    private String digest;
    private boolean hasIcon;
    private String docid;
    private String title;
    private int order;
    private int priority;
    private String ltitle;
    private String url_3w;
    private String lmodify;
    private String boardid;
    private String photosetID;
    private int imgsum;
    private String topic_background;
    private String template;
    private int votecount;
    private String skipID;
    private String TAGS;
    private String TAG;
    private String alias;
    private String skipType;
    private String cid;
    private int hasAD;
    private String source;
    private String ename;
    private String tname;
    private String imgsrc;
    private String ptime;
    private List<AdsBean> ads;
    private List<ImgextraBean> imgextra;
    private List<WapPluginfoBean> wap_pluginfo;
    private List<HouseAdPortalBean> house_adPortal;
    private LiveInfoBean live_info;

    public static NewsBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getJSONObject(key).toString(), NewsBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<NewsBean> arrayNewsBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<NewsBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getJSONArray(key).toString(), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPostid() {
        return postid;
    }

    public void setPostid(String postid) {
        this.postid = postid;
    }

    public boolean isHasCover() {
        return hasCover;
    }

    public void setHasCover(boolean hasCover) {
        this.hasCover = hasCover;
    }

    public int getHasHead() {
        return hasHead;
    }

    public void setHasHead(int hasHead) {
        this.hasHead = hasHead;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    public int getHasImg() {
        return hasImg;
    }

    public void setHasImg(int hasImg) {
        this.hasImg = hasImg;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getTAGS() {
        return TAGS;
    }

    public void setTAGS(String TAGS) {
        this.TAGS = TAGS;
    }

    public String getTAG() {
        return TAG;
    }

    public void setTAG(String TAG) {
        this.TAG = TAG;
    }

    public boolean isHasIcon() {
        return hasIcon;
    }

    public void setHasIcon(boolean hasIcon) {
        this.hasIcon = hasIcon;
    }

    public String getDocid() {
        return docid;
    }

    public void setDocid(String docid) {
        this.docid = docid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getLtitle() {
        return ltitle;
    }

    public void setLtitle(String ltitle) {
        this.ltitle = ltitle;
    }

    public String getUrl_3w() {
        return url_3w;
    }

    public void setUrl_3w(String url_3w) {
        this.url_3w = url_3w;
    }

    public String getLmodify() {
        return lmodify;
    }

    public void setLmodify(String lmodify) {
        this.lmodify = lmodify;
    }

    public String getBoardid() {
        return boardid;
    }

    public void setBoardid(String boardid) {
        this.boardid = boardid;
    }

    public String getPhotosetID() {
        return photosetID;
    }

    public void setPhotosetID(String photosetID) {
        this.photosetID = photosetID;
    }

    public int getImgsum() {
        return imgsum;
    }

    public void setImgsum(int imgsum) {
        this.imgsum = imgsum;
    }

    public String getTopic_background() {
        return topic_background;
    }

    public void setTopic_background(String topic_background) {
        this.topic_background = topic_background;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public int getVotecount() {
        return votecount;
    }

    public void setVotecount(int votecount) {
        this.votecount = votecount;
    }

    public String getSkipID() {
        return skipID;
    }

    public void setSkipID(String skipID) {
        this.skipID = skipID;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getSkipType() {
        return skipType;
    }

    public void setSkipType(String skipType) {
        this.skipType = skipType;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public int getHasAD() {
        return hasAD;
    }

    public void setHasAD(int hasAD) {
        this.hasAD = hasAD;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public String getPtime() {
        return ptime;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }

    public List<AdsBean> getAds() {
        return ads;
    }

    public void setAds(List<AdsBean> ads) {
        this.ads = ads;
    }

    public List<ImgextraBean> getImgextra() {
        return imgextra;
    }

    public void setImgextra(List<ImgextraBean> imgextra) {
        this.imgextra = imgextra;
    }

    public List<WapPluginfoBean> getWap_pluginfo() {
        return wap_pluginfo;
    }

    public void setWap_pluginfo(List<WapPluginfoBean> wap_pluginfo) {
        this.wap_pluginfo = wap_pluginfo;
    }

    public List<HouseAdPortalBean> getHouse_adPortal() {
        return house_adPortal;
    }

    public void setHouse_adPortal(List<HouseAdPortalBean> house_adPortal) {
        this.house_adPortal = house_adPortal;
    }

    public LiveInfoBean getLive_info() {
        return live_info;
    }

    public void setLive_info(LiveInfoBean live_info) {
        this.live_info = live_info;
    }

    public static class AdsBean {
        private String title;
        private String tag;
        private String imgsrc;
        private String subtitle;
        private String url;

        public static List<AdsBean> arrayAdsBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<AdsBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getJSONArray("ads").toString(), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "AdsBean{" +
                    "title='" + title + '\'' +
                    ", tag='" + tag + '\'' +
                    ", imgsrc='" + imgsrc + '\'' +
                    ", subtitle='" + subtitle + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }

    public static class ImgextraBean {
        private String imgsrc;

        public static List<ImgextraBean> arrayImgextraBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<ImgextraBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getJSONArray("imagextra").toString(), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        @Override
        public String toString() {
            return "ImgextraBean{" +
                    "imgsrc='" + imgsrc + '\'' +
                    '}';
        }
    }


    public static class WapPluginfoBean {
        private String title;
        private String subtitle;
        private String imgsrc;
        private String url;

        public static List<WapPluginfoBean> arrayWapPluginfoBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<WapPluginfoBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getJSONArray("wap_pluginfo").toString(), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "WapPluginfoBean{" +
                    "title='" + title + '\'' +
                    ", subtitle='" + subtitle + '\'' +
                    ", imgsrc='" + imgsrc + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }

    public static class HouseAdPortalBean {
        private String title;
        private String subtitle;
        private String imgsrc;
        private String url;

        public static List<HouseAdPortalBean> arrayHouseAdPortalBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<HouseAdPortalBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getJSONArray("house_adPortal").toString(), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "HouseAdPortalBean{" +
                    "title='" + title + '\'' +
                    ", subtitle='" + subtitle + '\'' +
                    ", imgsrc='" + imgsrc + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }

    public static class LiveInfoBean {
        private boolean mutilVideo;
        private boolean pano;
        private int remindTag;
        private String end_time;
        private int user_count;
        private int roomId;
        private String start_time;
        private int type;
        private boolean video;

        public static LiveInfoBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getJSONObject(key).toString(), LiveInfoBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<LiveInfoBean> arrayLiveInfoBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<LiveInfoBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getJSONArray(key).toString(), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public boolean isMutilVideo() {
            return mutilVideo;
        }

        public void setMutilVideo(boolean mutilVideo) {
            this.mutilVideo = mutilVideo;
        }

        public boolean isPano() {
            return pano;
        }

        public void setPano(boolean pano) {
            this.pano = pano;
        }

        public int getRemindTag() {
            return remindTag;
        }

        public void setRemindTag(int remindTag) {
            this.remindTag = remindTag;
        }

        public String getEnd_time() {
            return end_time;
        }

        public void setEnd_time(String end_time) {
            this.end_time = end_time;
        }

        public int getUser_count() {
            return user_count;
        }

        public void setUser_count(int user_count) {
            this.user_count = user_count;
        }

        public int getRoomId() {
            return roomId;
        }

        public void setRoomId(int roomId) {
            this.roomId = roomId;
        }

        public String getStart_time() {
            return start_time;
        }

        public void setStart_time(String start_time) {
            this.start_time = start_time;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public boolean isVideo() {
            return video;
        }

        public void setVideo(boolean video) {
            this.video = video;
        }

        @Override
        public String toString() {
            return "LiveInfoBean{" +
                    "mutilVideo=" + mutilVideo +
                    ", pano=" + pano +
                    ", remindTag=" + remindTag +
                    ", end_time='" + end_time + '\'' +
                    ", user_count=" + user_count +
                    ", roomId=" + roomId +
                    ", start_time='" + start_time + '\'' +
                    ", type=" + type +
                    ", video=" + video +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "NewsBean{" +
                "type=" + type +
                ", postid='" + postid + '\'' +
                ", hasCover=" + hasCover +
                ", hasHead=" + hasHead +
                ", replyCount=" + replyCount +
                ", hasImg=" + hasImg +
                ", digest='" + digest + '\'' +
                ", hasIcon=" + hasIcon +
                ", docid='" + docid + '\'' +
                ", title='" + title + '\'' +
                ", order=" + order +
                ", priority=" + priority +
                ", ltitle='" + ltitle + '\'' +
                ", url_3w='" + url_3w + '\'' +
                ", lmodify='" + lmodify + '\'' +
                ", boardid='" + boardid + '\'' +
                ", photosetID='" + photosetID + '\'' +
                ", imgsum=" + imgsum +
                ", topic_background='" + topic_background + '\'' +
                ", template='" + template + '\'' +
                ", votecount=" + votecount +
                ", skipID='" + skipID + '\'' +
                ", TAGS='" + TAGS + '\'' +
                ", TAG='" + TAG + '\'' +
                ", alias='" + alias + '\'' +
                ", skipType='" + skipType + '\'' +
                ", cid='" + cid + '\'' +
                ", hasAD=" + hasAD +
                ", source='" + source + '\'' +
                ", ename='" + ename + '\'' +
                ", tname='" + tname + '\'' +
                ", imgsrc='" + imgsrc + '\'' +
                ", ptime='" + ptime + '\'' +
                ", ads=" + ads +
                ", imgextra=" + imgextra +
                ", wap_pluginfo=" + wap_pluginfo +
                ", house_adPortal=" + house_adPortal +
                ", live_info=" + live_info +
                '}';
    }
}
