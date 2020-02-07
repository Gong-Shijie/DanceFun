package com.example.dancefun30.model;

import android.net.Uri;

import org.litepal.crud.DataSupport;

public class Article extends DataSupport {
    int cover;
    String title;
    Uri article;
    Boolean heartflag;

    public Boolean getHeartflag() {
        return heartflag;
    }

    public void setHeartflag(Boolean heartflag) {
        this.heartflag = heartflag;
    }

    public Article(int rid, String s, String s1) {
        article = Uri.parse(s);
        title = s1;
        cover = rid;
        heartflag = false;
    }

    public int getCover() {
        return cover;
    }



    public String getTitle() {
        return title;
    }


    public Uri getArticle() {
        return article;
    }


}
