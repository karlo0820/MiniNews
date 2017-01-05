package com.jiale.mininews.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Karlo on 2016/12/14.
 */

public class NewsDetailBean {
    private String body;
    private int replyCount;
    private String shareLink;
    private String digest;
    private String dkeys;
    private String ec;
    private String docid;
    private SourceinfoBean sourceinfo;
    private boolean picnews;
    private String title;
    private String tid;
    private String template;
    private int threadVote;
    private int threadAgainst;
    private String replyBoard;
    private String source;
    private boolean hasNext;
    private String voicecomment;
    private String ptime;
    private List<?> users;
    private List<?> ydbaike;
    private List<?> link;
    private List<?> votes;
    private List<?> boboList;
    private List<ImgBean> img;
    private List<SpinfoBean> spinfo;
    private List<TopiclistNewsBean> topiclist_news;
    private List<TopiclistBean> topiclist;
    private List<AskbarBean> askbar;
    private List<RelativeSysBean> relative_sys;

    public static NewsDetailBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getJSONObject(key).toString(), NewsDetailBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<NewsDetailBean> arrayNewsDetailBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<NewsDetailBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getJSONArray(key).toString(), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    public String getShareLink() {
        return shareLink;
    }

    public void setShareLink(String shareLink) {
        this.shareLink = shareLink;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getDkeys() {
        return dkeys;
    }

    public void setDkeys(String dkeys) {
        this.dkeys = dkeys;
    }

    public String getEc() {
        return ec;
    }

    public void setEc(String ec) {
        this.ec = ec;
    }

    public String getDocid() {
        return docid;
    }

    public void setDocid(String docid) {
        this.docid = docid;
    }

    public SourceinfoBean getSourceinfo() {
        return sourceinfo;
    }

    public void setSourceinfo(SourceinfoBean sourceinfo) {
        this.sourceinfo = sourceinfo;
    }

    public boolean isPicnews() {
        return picnews;
    }

    public void setPicnews(boolean picnews) {
        this.picnews = picnews;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public int getThreadVote() {
        return threadVote;
    }

    public void setThreadVote(int threadVote) {
        this.threadVote = threadVote;
    }

    public int getThreadAgainst() {
        return threadAgainst;
    }

    public void setThreadAgainst(int threadAgainst) {
        this.threadAgainst = threadAgainst;
    }

    public String getReplyBoard() {
        return replyBoard;
    }

    public void setReplyBoard(String replyBoard) {
        this.replyBoard = replyBoard;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public String getVoicecomment() {
        return voicecomment;
    }

    public void setVoicecomment(String voicecomment) {
        this.voicecomment = voicecomment;
    }

    public String getPtime() {
        return ptime;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }

    public List<?> getUsers() {
        return users;
    }

    public void setUsers(List<?> users) {
        this.users = users;
    }

    public List<?> getYdbaike() {
        return ydbaike;
    }

    public void setYdbaike(List<?> ydbaike) {
        this.ydbaike = ydbaike;
    }

    public List<?> getLink() {
        return link;
    }

    public void setLink(List<?> link) {
        this.link = link;
    }

    public List<?> getVotes() {
        return votes;
    }

    public void setVotes(List<?> votes) {
        this.votes = votes;
    }

    public List<?> getBoboList() {
        return boboList;
    }

    public void setBoboList(List<?> boboList) {
        this.boboList = boboList;
    }

    public List<ImgBean> getImg() {
        return img;
    }

    public void setImg(List<ImgBean> img) {
        this.img = img;
    }

    public List<SpinfoBean> getSpinfo() {
        return spinfo;
    }

    public void setSpinfo(List<SpinfoBean> spinfo) {
        this.spinfo = spinfo;
    }

    public List<TopiclistNewsBean> getTopiclist_news() {
        return topiclist_news;
    }

    public void setTopiclist_news(List<TopiclistNewsBean> topiclist_news) {
        this.topiclist_news = topiclist_news;
    }

    public List<TopiclistBean> getTopiclist() {
        return topiclist;
    }

    public void setTopiclist(List<TopiclistBean> topiclist) {
        this.topiclist = topiclist;
    }

    public List<AskbarBean> getAskbar() {
        return askbar;
    }

    public void setAskbar(List<AskbarBean> askbar) {
        this.askbar = askbar;
    }

    public List<RelativeSysBean> getRelative_sys() {
        return relative_sys;
    }

    public void setRelative_sys(List<RelativeSysBean> relative_sys) {
        this.relative_sys = relative_sys;
    }

    public static class SourceinfoBean {
        private String alias;
        private String ename;
        private String tname;
        private String tid;

        public static SourceinfoBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getJSONObject("sourceinfo").toString(), SourceinfoBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<SourceinfoBean> arraySourceinfoBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<SourceinfoBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getJSONArray("sourceinfo").toString(), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
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

        public String getTid() {
            return tid;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }

        @Override
        public String toString() {
            return "SourceinfoBean{" +
                    "alias='" + alias + '\'' +
                    ", ename='" + ename + '\'' +
                    ", tname='" + tname + '\'' +
                    ", tid='" + tid + '\'' +
                    '}';
        }
    }

    public static class SpinfoBean {
        private String ref;
        private String spcontent;
        private String sptype;

        public static SpinfoBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getJSONObject("spinfo").toString(), SpinfoBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<SpinfoBean> arraySpinfoBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<SpinfoBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getJSONArray("spinfo").toString(), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public String getRef() {
            return ref;
        }

        public void setRef(String ref) {
            this.ref = ref;
        }

        public String getSpcontent() {
            return spcontent;
        }

        public void setSpcontent(String spcontent) {
            this.spcontent = spcontent;
        }

        public String getSptype() {
            return sptype;
        }

        public void setSptype(String sptype) {
            this.sptype = sptype;
        }

        @Override
        public String toString() {
            return "SpinfoBean{" +
                    "ref='" + ref + '\'' +
                    ", spcontent='" + spcontent + '\'' +
                    ", sptype='" + sptype + '\'' +
                    '}';
        }
    }

    public static class ImgBean {
        private String ref;
        private String pixel;
        private String alt;
        private String src;

        public static ImgBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getJSONObject("img").toString(), ImgBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<ImgBean> arrayImgBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<ImgBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getJSONArray("img").toString(), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public String getRef() {
            return ref;
        }

        public void setRef(String ref) {
            this.ref = ref;
        }

        public String getPixel() {
            return pixel;
        }

        public void setPixel(String pixel) {
            this.pixel = pixel;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }

        @Override
        public String toString() {
            return "ImgBean{" +
                    "ref='" + ref + '\'' +
                    ", pixel='" + pixel + '\'' +
                    ", alt='" + alt + '\'' +
                    ", src='" + src + '\'' +
                    '}';
        }
    }

    public static class TopiclistNewsBean {
        private boolean hasCover;
        private String subnum;
        private String alias;
        private String tname;
        private String ename;
        private String tid;
        private String cid;

        public static TopiclistNewsBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getJSONObject("topiclist_news").toString(), TopiclistNewsBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<TopiclistNewsBean> arrayTopiclistNewsBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<TopiclistNewsBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getJSONArray("topiclist_news").toString(), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public boolean isHasCover() {
            return hasCover;
        }

        public void setHasCover(boolean hasCover) {
            this.hasCover = hasCover;
        }

        public String getSubnum() {
            return subnum;
        }

        public void setSubnum(String subnum) {
            this.subnum = subnum;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getTname() {
            return tname;
        }

        public void setTname(String tname) {
            this.tname = tname;
        }

        public String getEname() {
            return ename;
        }

        public void setEname(String ename) {
            this.ename = ename;
        }

        public String getTid() {
            return tid;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        @Override
        public String toString() {
            return "TopiclistNewsBean{" +
                    "hasCover=" + hasCover +
                    ", subnum='" + subnum + '\'' +
                    ", alias='" + alias + '\'' +
                    ", tname='" + tname + '\'' +
                    ", ename='" + ename + '\'' +
                    ", tid='" + tid + '\'' +
                    ", cid='" + cid + '\'' +
                    '}';
        }
    }

    public static class TopiclistBean {
        private boolean hasCover;
        private String subnum;
        private String alias;
        private String tname;
        private String ename;
        private String tid;
        private String cid;

        public static TopiclistBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getJSONObject("topiclist").toString(), TopiclistBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<TopiclistBean> arrayTopiclistBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<TopiclistBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getJSONArray("topiclist").toString(), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public boolean isHasCover() {
            return hasCover;
        }

        public void setHasCover(boolean hasCover) {
            this.hasCover = hasCover;
        }

        public String getSubnum() {
            return subnum;
        }

        public void setSubnum(String subnum) {
            this.subnum = subnum;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getTname() {
            return tname;
        }

        public void setTname(String tname) {
            this.tname = tname;
        }

        public String getEname() {
            return ename;
        }

        public void setEname(String ename) {
            this.ename = ename;
        }

        public String getTid() {
            return tid;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        @Override
        public String toString() {
            return "TopiclistBean{" +
                    "hasCover=" + hasCover +
                    ", subnum='" + subnum + '\'' +
                    ", alias='" + alias + '\'' +
                    ", tname='" + tname + '\'' +
                    ", ename='" + ename + '\'' +
                    ", tid='" + tid + '\'' +
                    ", cid='" + cid + '\'' +
                    '}';
        }
    }

    public static class AskbarBean {
        private String title;
        private String headpicurl;
        private String alias;
        private String expertId;
        private String name;
        private int concernCount;

        public static AskbarBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getJSONObject("askbar").toString(), AskbarBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<AskbarBean> arrayAskbarBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<AskbarBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getJSONArray("askbar").toString(), listType);

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

        public String getHeadpicurl() {
            return headpicurl;
        }

        public void setHeadpicurl(String headpicurl) {
            this.headpicurl = headpicurl;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getExpertId() {
            return expertId;
        }

        public void setExpertId(String expertId) {
            this.expertId = expertId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getConcernCount() {
            return concernCount;
        }

        public void setConcernCount(int concernCount) {
            this.concernCount = concernCount;
        }

        @Override
        public String toString() {
            return "AskbarBean{" +
                    "title='" + title + '\'' +
                    ", headpicurl='" + headpicurl + '\'' +
                    ", alias='" + alias + '\'' +
                    ", expertId='" + expertId + '\'' +
                    ", name='" + name + '\'' +
                    ", concernCount=" + concernCount +
                    '}';
        }
    }

    public static class RelativeSysBean {
        private String id;
        private String title;
        private String source;
        private String imgsrc;
        private String docID;
        private String from;
        private String type;
        private String ptime;
        private String href;

        public static RelativeSysBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getJSONObject("relative_sys").toString(), RelativeSysBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<RelativeSysBean> arrayRelativeSysBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<RelativeSysBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getJSONArray("relative_sys").toString(), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        public String getDocID() {
            return docID;
        }

        public void setDocID(String docID) {
            this.docID = docID;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        @Override
        public String toString() {
            return "RelativeSysBean{" +
                    "id='" + id + '\'' +
                    ", title='" + title + '\'' +
                    ", source='" + source + '\'' +
                    ", imgsrc='" + imgsrc + '\'' +
                    ", docID='" + docID + '\'' +
                    ", from='" + from + '\'' +
                    ", type='" + type + '\'' +
                    ", ptime='" + ptime + '\'' +
                    ", href='" + href + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "NewsDetailBean{" +
                "body='" + body + '\'' +
                ", replyCount=" + replyCount +
                ", shareLink='" + shareLink + '\'' +
                ", digest='" + digest + '\'' +
                ", dkeys='" + dkeys + '\'' +
                ", ec='" + ec + '\'' +
                ", docid='" + docid + '\'' +
                ", sourceinfo=" + sourceinfo +
                ", picnews=" + picnews +
                ", title='" + title + '\'' +
                ", tid='" + tid + '\'' +
                ", template='" + template + '\'' +
                ", threadVote=" + threadVote +
                ", threadAgainst=" + threadAgainst +
                ", replyBoard='" + replyBoard + '\'' +
                ", source='" + source + '\'' +
                ", hasNext=" + hasNext +
                ", voicecomment='" + voicecomment + '\'' +
                ", ptime='" + ptime + '\'' +
                ", users=" + users +
                ", spinfo=" + spinfo +
                ", ydbaike=" + ydbaike +
                ", link=" + link +
                ", img=" + img +
                ", votes=" + votes +
                ", topiclist_news=" + topiclist_news +
                ", topiclist=" + topiclist +
                ", askbar=" + askbar +
                ", boboList=" + boboList +
                ", relative_sys=" + relative_sys +
                '}';
    }
}
 /*{"C8874FFF0001875N":{"body":"<p>　　国台办12月14日上午举行新闻发布会，发言人安峰山就近期两岸关系热点问题答记者问。<\/p><p>　　新华社记者：据报道，美国当选总统特朗普日前在接受采访时称，他完全理解一个中国政策，但不明白美方为什么必须受一个中国政策束缚，除非美中就贸易等其他议题达成协议，对此有何评论？谢谢。<\/p><p>　　安峰山：外交部发言人已就此表明了我们的立场和态度。台湾问题事关中国主权和领土完整，涉及中方核心利益。坚持一个中国原则，是发展中美关系的政治基础，也是台海和平稳定的基石。如果这一基础受到干扰和破坏，中美关系的健康稳定发展就无从谈起，台海和平稳定也必将遭受严重冲击。<\/p><p>　　中央电视台记者：还是想延续一下关于特朗普涉及到一中政策言论的问题。我们注意到，其实在他这个言论提出来之后，台湾内部，包括有民进党和“时代力量”的一些民意代表提出来，是不是蔡英文提出的所谓“维持现状”这个说法也已过时，台湾是否可以不受限于一中框架？请问发言人对此有何评论？<\/p><p>　　安峰山：我想这种言论充分暴露了岛内一些政治势力一心谋求“台独”分裂的本质，以及为了实现他们的“台独”梦想那种急不可待的心态。我想强调的是，世界上只有一个中国，大陆和台湾同属一个中国，这具有不可辩驳的法理依据和事实依据，也是国际社会公认的现实。我们坚持一个中国原则，反对和遏制“台独”分裂的立场是坚定不移的。在反“台独”、反分裂这个问题上，我们有坚定的意志、充分的信心、足够的能力。我想事实会告诉这些人，“台独”是一条走不通的死路。<\/p><!--SPINFO#0--><\/p><p>原标题：国台办12月14日例行新闻发布会<\/p>","users":[],"spinfo":[{"ref":"<!--SPINFO#0-->","spcontent":"<br/><a href=\"http://news.163.com/16/1213/08/C85DHKAH000187VE.html\">特朗普公开质疑\"一个中国\" 是不懂还是另有所图？<\/a><br/>“他不明白台湾问题是中美关系中最错综复杂最敏感的问题，”外交学院国际关系研究所教授李海东在接受澎湃新闻的采访时认为，特朗普之所以做出这样的表态是因为他在政治外交方面是一个新手。<br/>“特朗普认为台湾问题可以像做生意那样，实际上在中国看来这是很幼稚的，很不成熟。中国在台湾问题的立场很清楚，台湾不是一个可以做交易的对象。”李海东说。<br/>社科院美国研究所研究员刘卫东也认为，特朗普在台湾问题上的表态是想要与中国做交易，认为中国没有在贸易问题上给美国一些回报。<br/><a href=\"http://news.163.com/16/1213/06/C8578EVL0001875O.html\">白宫10天内3次重申美国政府坚定奉行一个中国政策<\/a><br/>新华社华盛顿12月12日电 美国白宫12日重申，美国政府坚定奉行一个中国政策。","sptype":"回顾"}],"ydbaike":[],"replyCount":42782,"link":[],"img":[{"ref":"<!--IMG#0-->","pixel":"457*540","alt":"","src":"http://cms-bucket.nosdn.127.net/catchpic/5/5c/5cf88e2d966894bb7b15bec6612f05ab.jpg"}],"votes":[],"shareLink":"http://c.m.163.com/news/a/C8874FFF0001875N.html?spss=newsapp&spsw=1","digest":"","topiclist_news":[{"hasCover":false,"subnum":"0","alias":"yaowentuisong","tname":"要闻推送","ename":"pushliebiao","tid":"T1350294190231","cid":"C1350294152567"},{"hasCover":false,"subnum":"3.2万","alias":"Top News","tname":"头条","ename":"androidnews","tid":"T1348647909107","cid":"C1348646712614"},{"hasCover":false,"subnum":"超过1000万","alias":"Top News","tname":"头条","ename":"iosnews","tid":"T1348647853363","cid":"C1348646712614"},{"hasCover":false,"subnum":"0","alias":"todayNews2","tname":"今日要闻","ename":"todayNews2","tid":"T1429173762551","cid":"C1350294152567"},{"hasCover":false,"subnum":"9.3万","alias":"yaowenspecial","tname":"要闻","ename":"yaowenspecial","tid":"T1467284926140","cid":"C1348647991705"},{"hasCover":false,"subnum":"0","alias":"newsToday1","tname":"今日要闻","ename":"newsToday1","tid":"T1429173683626","cid":"C1350294152567"},{"hasCover":false,"subnum":"0","alias":"androidpush","tname":"push列表（android）","ename":"androidpush","tid":"T1371543208049","cid":"C1350294152567"}],"dkeys":"特朗普,一个中国政策,国台办,民进党,台独","ec":"姬雪莹_NN6784","topiclist":[{"hasCover":false,"subnum":"897.4万","alias":"最快速最全面的国内政经资讯","tname":"网易国内","ename":"guonei","tid":"T1348648101594","cid":"C1378977941637"}],"docid":"C8874FFF0001875N","sourceinfo":{"alias":"关注台湾，解读两岸。","ename":"T1457017380512","tname":"中国台湾网","tid":"T1457017380512"},"picnews":true,"title":"特朗普声称不懂为何要接受一个中国政策 国台办回应","tid":"","template":"normal1","threadVote":3,"askbar":[{"title":"军事评论员","headpicurl":"http://dingyue.nosdn.127.net/bbJxOHulJfzB2fzKyslP4bs4q3EjBAYTZ4qtvZxiNQhoY1465719317989.jpg","alias":" 我是军事评论员杨艳月，关于军事战争、武器装备、军事动态的相关问题，问我吧！","expertId":"EX01392770972601712204","name":"杨艳月","concernCount":80057}],"threadAgainst":2,"boboList":[],"replyBoard":"news_guonei8_bbs","source":"中国台湾网","hasNext":false,"voicecomment":"off","relative_sys":[{"id":"C7AFF8GH0001875N","title":"张志军：绝不允许台商大陆挣钱 回台却支持\"台独\"","source":"环球时报","imgsrc":"http://cms-bucket.nosdn.127.net/4a44ba9462d64bcc930d245f6b2fc98320161202212102.png","docID":"C7AFF8GH0001875N","from":"HZ","type":"doc","ptime":"2016-12-02 21:20:26","href":""},{"id":"C7GOKKL1000181KT","title":"特朗普\"台湾电话\"遭质疑 美媒讽称菜鸟犯下的错误","source":"环球网","imgsrc":"http://img3.cache.netease.com/photo/0001/2016-12-02/C79D166000AO0001.550x.0.jpg","docID":"C7GOKKL1000181KT","from":"HZ","type":"doc","ptime":"2016-12-05 07:56:06","href":""},{"id":"C7MFF48U0001875O","title":"美媒：共和党大佬策划川蔡通话 台湾送14万美元","source":"网易国际","imgsrc":"http://cms-bucket.nosdn.127.net/catchpic/7/75/753231352d7f91185ae50ed67c5b267f.jpg","docID":"C7MFF48U0001875O","from":"HZ","type":"doc","ptime":"2016-12-07 13:11:15","href":""}],"ptime":"2016-12-14 10:31:57"}}*/