package com.example.dancefun30.model;

import android.net.Uri;

import org.litepal.crud.DataSupport;

public class Loog extends DataSupport {
    private String  photo;
    String content;

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String  photo) {
        this.photo = photo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
