package com.example.dancefun30.pre;

import com.example.dancefun30.model.FavorArticle;

public class FavorIni {
    private static final FavorIni ourInstance = new FavorIni();

    public static FavorIni getInstance() {
        return ourInstance;
    }

    private FavorIni() {
        for(int i=0;i<10;i++){
            FavorArticle favorArticle = new FavorArticle();
            favorArticle.setFid(i);
            favorArticle.setHeartFlag(false);
            favorArticle.save();
        }
    }
}
