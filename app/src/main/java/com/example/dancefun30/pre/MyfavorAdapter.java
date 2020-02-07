package com.example.dancefun30.pre;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dancefun30.R;
import com.example.dancefun30.model.Article;
import com.example.dancefun30.model.FavorArticle;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class MyfavorAdapter extends RecyclerView.Adapter<MyfavorAdapter.ViewHolder> {
    private List<Article> articleList;

    private List<Article> myfavorArtList ;
    private  List<FavorArticle> favorArticleList;

    Context context;


    public MyfavorAdapter(List<Article> articleList,  Context context) {
        this.articleList = articleList;
        myfavorArtList = new ArrayList<>();
      favorArticleList =   DataSupport.findAll(FavorArticle.class);
        for (int i=0;i<10;i++)
        {
            if(favorArticleList.get(i).getHeartFlag()==true){
                myfavorArtList.add(articleList.get(i));
            }
        }
        this.context = context;

    }

    @NonNull
    @Override
    public MyfavorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemfav_layout,parent,false);
        final MyfavorAdapter.ViewHolder viewHolder= new MyfavorAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyfavorAdapter.ViewHolder holder, int position) {

        Article article = myfavorArtList.get(position);
        holder.coverImage.setImageResource(article.getCover());
        holder.artContent.setText(article.getTitle());
    }

    @Override
    public int getItemCount() {
        return myfavorArtList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        View myfavArticle_view;
        ImageView coverImage;
        TextView artContent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            myfavArticle_view = itemView.findViewById(R.id.favArticle_view);
            coverImage = itemView.findViewById(R.id.favArticle_photo);
            artContent = itemView.findViewById(R.id.favArticle_content);
        }
    }
}
