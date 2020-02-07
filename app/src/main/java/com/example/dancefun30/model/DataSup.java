package com.example.dancefun30.model;

import com.example.dancefun30.R;

import java.util.ArrayList;
import java.util.List;

public class DataSup {
    List<Article> articleList = new ArrayList<>();
    List<Integer> favList = new ArrayList<>();

    public List<Integer> getFavList() {
        return favList;
    }

    public void setFavList(List<Integer> favList) {
        this.favList = favList;
    }

    public DataSup() {

       articleList.add(new Article(R.drawable.caver1,"http://mp.weixin.qq.com/s/E1ulJIiMCSVd-rS2XbVa6A","1M舞室 Koosung Jung 编舞\n音乐：Paradise-Bazzi\n编舞：Koosung Jung"));
       articleList.add(new Article(R.drawable.caver2,"https://mp.weixin.qq.com/s/uXo_mtIHt8AXoKqIJFMjqA","1M舞室 Tina Boo 最新编舞视频 \n2 - H.E.R / Tina Boo"));
       articleList.add(new Article(R.drawable.caver3,"https://mp.weixin.qq.com/s/VuCF6lcehcFRCNXoOQw8Ww","1M舞室 Enoh 最新编舞 \nOld Town Road (Remix) - Liil Nas"));
       articleList.add(new Article(R.drawable.caver4,"https://mp.weixin.qq.com/s/RwoIjyrNH1-GdsuBmaPmXw","1M舞室 Jiyoung Youn 最新编舞\nSwalla - Jason Derulo ft.Nicki & Ty Dolla"));
       articleList.add(new Article(R.drawable.caver5,"https://mp.weixin.qq.com/s/rRddIdUtMm6oJJ-UBYg5WA","1M舞室 Jinwoo Yoon \nBee Like ME"));
       articleList.add(new Article(R.drawable.caver6,"https://mp.weixin.qq.com/s/e4-PSCuuzAeOExs9v3vGXA","1M舞室 May J Lee 编舞 24K Magic \nremix - Bruno Mars"));
       articleList.add(new Article(R.drawable.caver7,"https://mp.weixin.qq.com/s/3XiHhmygpN4L4xL4sNWf7Q","1M舞室 Hyojin Choi 最新编舞视频\nGirl Gone Wild - Madonna"));
       articleList.add(new Article(R.drawable.caver8,"https://mp.weixin.qq.com/s/lScICwvdF3xaxVfl5R3Igw","1M舞室 Junsun Yoo 最新编舞视频 London Town\nAnt,Playboi Carti?Junsun Yoo"));
       articleList.add(new Article(R.drawable.caver9,"https://mp.weixin.qq.com/s/iQl0dKAGGvz6vJDYaJgzmg","1M舞室 Isabelle 最新编舞基础 Orange Tree\nFor Beginners Class"));
       articleList.add(new Article(R.drawable.caver10,"https://mp.weixin.qq.com/s/Hp0qJhD12N_fG06DG0dANw","1M舞室 Tina Boo 编舞 Jun Liu Choreography\nI Konw what you did last Summer"));
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    public List<Article> getArticleList() {
        return articleList;
    }
}
