package com.example.dancefun30.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.dancefun30.R;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class LoopviewActivity extends AppCompatActivity {
    private Banner mBanner;
    private ArrayList<Integer> images;
    private ArrayList<String> imageTitle;
    ImageView toLogin_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loopview);
    mBanner = (Banner) findViewById(R.id.banner);
        //初始化数据
        initData();
        //初始化view
        initView();


    }
    private void initView() {


        mBanner = (Banner) findViewById(R.id.banner);
        //设置样式,默认为:Banner.NOT_INDICATOR(不显示指示器和标题)
        //可选样式如下:
        //1. Banner.CIRCLE_INDICATOR    显示圆形指示器
        //2. Banner.NUM_INDICATOR   显示数字指示器
        //3. Banner.NUM_INDICATOR_TITLE 显示数字指示器和标题
        //4. Banner.CIRCLE_INDICATOR_TITLE  显示圆形指示器和标题
        //设置banner样式
        mBanner.setBannerStyle(0);
        //设置图片加载器
        mBanner.setImageLoader(new GlideImageLoader());
        //设置标题集合（当banner样式有显示title时）
        mBanner.setBannerTitles(imageTitle);
        //设置轮播样式（没有标题默认为右边,有标题时默认左边）
        //可选样式:
        //Banner.LEFT   指示器居左
        //Banner.CENTER 指示器居中
        //Banner.RIGHT  指示器居右
        mBanner.setIndicatorGravity(BannerConfig.CENTER);
        //设置是否允许手动滑动轮播图
        mBanner.setViewPagerIsScroll(true);
        //设置是否自动轮播（不设置则默认自动）
        mBanner.isAutoPlay(true);
        //设置轮播图片间隔时间（不设置默认为2000）
        mBanner.setDelayTime(1500);
        //设置图片资源:可选图片网址/资源文件，默认用Glide加载,也可自定义图片的加载框架
        //所有设置参数方法都放在此方法之前执行
        mBanner.setIndicatorGravity(BannerConfig.CENTER);
        mBanner.setImages(images).start();
        toLogin_btn  = findViewById(R.id.toLogin_btn);
        toLogin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent();
                intent.setClass(LoopviewActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initData() {
        //设置图片资源:url或本地资源
        images = new ArrayList<>();
        images.add(R.drawable.loopview1);
        images.add(R.drawable.loopview2);
        images.add(R.drawable.loopview4);
        images.add(R.drawable.loopview3);

        //设置图片标题:自动对应
        imageTitle = new ArrayList<>();
        imageTitle.add(null);
        imageTitle.add(null);
        imageTitle.add(null);
        imageTitle.add(null);




    }
    public class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context)
                    .load(path)
                    .into(imageView);
        }
    }
}
