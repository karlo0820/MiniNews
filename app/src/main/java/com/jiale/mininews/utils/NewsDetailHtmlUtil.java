package com.jiale.mininews.utils;

import com.jiale.mininews.bean.NewsDetailBean;

import java.util.List;

/**
 * Created by Karlo on 2016/12/14.
 */

public class NewsDetailHtmlUtil {
    public static NewsDetailBean dealHtml(NewsDetailBean bean) {
        List<NewsDetailBean.ImgBean> imgs = bean.getImg();
        StringBuilder sb = new StringBuilder();
        sb.append("<style>img{max-width:100%;height:auto;}</style>");
        sb.append(bean.getBody());
        if (imgs != null) {
            for (NewsDetailBean.ImgBean imgBean : imgs) {
                String ref = imgBean.getRef();
                LogUtil.i("ref:", ref);
                int refIndex = sb.indexOf(ref);
                String value = "<br><img src=\"" + imgBean.getSrc() + "\"/><br>";
                LogUtil.i("value:", value);
                sb.replace(refIndex, refIndex + ref.length(), value);
            }
        }
        List<NewsDetailBean.SpinfoBean> spinfos = bean.getSpinfo();
        if (spinfos != null) {
            for (NewsDetailBean.SpinfoBean spinfoBean : spinfos) {
                String ref = spinfoBean.getRef();
                int refIndex = sb.indexOf(ref);
                String value = "<br><p>" + spinfoBean.getSptype() + "</p>" + spinfoBean.getSpcontent();
                LogUtil.i("value:", value);
                sb.replace(refIndex, refIndex + ref.length(), value);
            }
        }
        bean.setBody(sb.toString());
        LogUtil.i("dealHtml:", bean.getBody());
        return bean;
    }
}
