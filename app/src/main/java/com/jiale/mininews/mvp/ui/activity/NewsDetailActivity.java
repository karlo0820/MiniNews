package com.jiale.mininews.mvp.ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jiale.mininews.R;
import com.jiale.mininews.bean.NewsDetailBean;
import com.jiale.mininews.mvp.presenter.NewsDetailPresenterImpl;
import com.jiale.mininews.mvp.view.INewsDetailView;
import com.jiale.mininews.utils.AppUtil;
import com.jiale.mininews.utils.IntentUtil;
import com.jiale.mininews.utils.LogUtil;
import com.squareup.picasso.Picasso;

import java.net.URL;

import butterknife.BindView;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by Karlo on 2016/12/14.
 */

public class NewsDetailActivity extends BaseActivity implements INewsDetailView, View.OnClickListener {
    private static final String TAG = "NewsDetailActivity";
    @BindView(R.id.newsdetail_headimg)
    ImageView newsdetailHeadimg;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.newsdetail_collaps)
    CollapsingToolbarLayout newsdetailCollaps;
    @BindView(R.id.newsdetail_appbarlayout)
    AppBarLayout newsdetailAppbarlayout;
    @BindView(R.id.newsdetail_src_time)
    TextView newsdetailSrcTime;
    @BindView(R.id.newsdetail_webview)
    WebView newsdetailWebview;
    @BindView(R.id.newsdetail_shared)
    FloatingActionButton newsdetailShared;
    //    @BindView(R.id.newsdetail_text)
//    TextView newsdetailText;
    private NewsDetailPresenterImpl detailPresenter;
    private String postId;
    private String imgsrc;
    private NewsDetailBean newsDetailBean;

    @Override
    public int getLayoutId() {
//        struct();
        return R.layout.activity_newsdetail;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initEvent() {
        newsdetailShared.setOnClickListener(this);
    }

    @Override
    protected void initViews() {
        newsdetailWebview.setWebChromeClient(new WebChromeClient());
        newsdetailWebview.setWebViewClient(new WebViewClient());
        newsdetailWebview.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        newsdetailWebview.getSettings().setSupportZoom(false);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        postId = intent.getStringExtra(IntentUtil.NEWSDETAIL_POSTID);
        imgsrc = intent.getStringExtra(IntentUtil.NEWSDETAIL_IMGSRC);
        Picasso.with(this).load(imgsrc).placeholder(R.mipmap.ic_loading).error(R.mipmap.ic_load_fail).config(Bitmap.Config.ARGB_8888).into(newsdetailHeadimg);
        LogUtil.i(TAG, postId + "-" + imgsrc);
        detailPresenter = new NewsDetailPresenterImpl(this);
        detailPresenter.getData(postId);
    }

    int windowWidth = AppUtil.getWindowWidth();

    Html.ImageGetter imageGetter = new Html.ImageGetter() {
        @Override
        public Drawable getDrawable(String source) {
            Log.i("Google.Karlo", TAG + "- getDrawable:" + source);
            Drawable drawable = null;
            URL url;
            try {
                url = new URL(source);
                drawable = Drawable.createFromStream(url.openStream(), ""); // 获取网路图片
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            // 限制图片在TextView中的边界大小
            drawable.setBounds(
                    0,
                    0,
                    windowWidth,
                    windowWidth * drawable.getIntrinsicHeight()
                            / drawable.getIntrinsicWidth());
            return drawable;
        }
    };

    @Override
    public void showData(NewsDetailBean bean) {
        newsDetailBean = bean;
        newsdetailCollaps.setTitle(bean.getTitle());
        newsdetailSrcTime.setText(bean.getSource() + " " + bean.getPtime());
        newsdetailWebview.loadDataWithBaseURL(null, bean.getBody(), "text/html", "UTF-8", null);
//        newsdetailWebview.loadData(bean.getBody(), "text/html", "UTF-8");


//        newsdetailText.setMovementMethod(ScrollingMovementMethod.getInstance());
//        newsdetailText.setMovementMethod(LinkMovementMethod.getInstance());
//        newsdetailText.setText(Html.fromHtml(bean.getBody(), imageGetter, null));
//        LogUtil.i(TAG, Html.fromHtml(bean.getBody()).toString());
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.newsdetail_shared) {
            Toast.makeText(this, "分享：" + (newsDetailBean == null ? null :
                    newsDetailBean.getShareLink()), Toast.LENGTH_SHORT).show();
            if (newsDetailBean != null) {
                showShare();
            }
        }
    }

    private void showShare() {
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();
        // title标题，印象笔记、邮箱、信息、微信、人人网、QQ和QQ空间使用
        oks.setTitle(getResources().getString(R.string.shareTitle));
        // titleUrl是标题的网络链接，仅在Linked-in,QQ和QQ空间使用
        oks.setTitleUrl(newsDetailBean.getShareLink());
        // text是分享文本，所有平台都需要这个字段
        oks.setText(newsDetailBean.getTitle());
        //分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
        oks.setImageUrl(imgsrc);
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl(newsDetailBean.getShareLink());
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
//        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
//        oks.setSite("ShareSDK");
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
//        oks.setSiteUrl("http://sharesdk.cn");

// 启动分享GUI
        oks.show(this);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            LogUtil.i("", "回退");
            hideWebview();
        }
        return super.onKeyDown(keyCode, event);
    }

    private void hideWebview() {
        if (newsdetailWebview != null) {
            newsdetailWebview.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            hideWebview();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void finish() {
        super.finish();
        newsdetailWebview.destroy();
    }

    // 严苛模式
    public static void struct() {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectDiskReads().detectDiskWrites().detectNetwork() // or
                // .detectAll()
                // for
                // all
                // detectable
                // problems
                .penaltyLog().build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects() // 探测SQLite数据库操作
                .penaltyLog() // 打印logcat
                .penaltyDeath().build());
    }
}
