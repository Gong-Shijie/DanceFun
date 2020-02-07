package com.example.dancefun30.model;

import org.litepal.crud.DataSupport;

public class FavorArticle  extends DataSupport {


    int fid ;
    Boolean heartFlag;

    public FavorArticle() {
    }

    public Boolean getHeartFlag() {
        return heartFlag;
    }

    public void setHeartFlag(Boolean heartFlag) {
        this.heartFlag = heartFlag;
    }
    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }
}
