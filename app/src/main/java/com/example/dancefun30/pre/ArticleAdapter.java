package com.example.dancefun30.pre;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
import com.example.dancefun30.view.WebviewActivity;

import org.litepal.crud.DataSupport;

import java.util.List;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {
    private List<Article> articleList;
    private List<FavorArticle> favorArticles;
    Context context;

    public ArticleAdapter(List<Article> articleList, Context context) {
        this.articleList = articleList;
        this.context = context;
        favorArticles = DataSupport.findAll(FavorArticle.class);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i("gong", "onCreateViewHolder");

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemart_layout, parent, false);

        final ArticleAdapter.ViewHolder viewHolder = new
                ArticleAdapter.ViewHolder(view, articleList);
        viewHolder.articleItem_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("gong", "intent!");
                int position = viewHolder.getAdapterPosition();
                viewWeb(articleList.get(position).getArticle());
            }
        });
        viewHolder.heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chageHeart();

            }

            private void chageHeart() {
                int positon = viewHolder.getAdapterPosition();
                Log.i("gong", "Posion: " + positon + "");
                if (favorArticles.get(positon).getHeartFlag() == false) {
                    viewHolder.heart.setImageResource(R.drawable.ic_heartfull);
                }
                if (favorArticles.get(positon).getHeartFlag() == true) {
                    viewHolder.heart.setImageResource(R.drawable.ic_heart);
                }
                FavorArticle favorArticle = new FavorArticle();
                favorArticle.setHeartFlag(!favorArticles.get(positon).getHeartFlag());
                favorArticle.updateAll("fid=?", String.valueOf(positon));
                favorArticles = DataSupport.findAll(FavorArticle.class);
            }
        });
        return viewHolder;
    }

    private void viewWeb(Uri article) {
        Log.i("gong", "intent!");
//        Intent intent = new Intent(Intent.ACTION_VIEW, article);
        Intent intent = new Intent();
        intent.putExtra("Uri",article.toString());
        intent.setClass(context, WebviewActivity.class);
        intent.addFlags(FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.i("gong", "onBindViewHolder");
        Article article = articleList.get(position);
        holder.coverImage.setImageResource(article.getCover());
        holder.artContent.setText(article.getTitle());
        favorArticles = DataSupport.findAll(FavorArticle.class);
        if (favorArticles.get(position).getHeartFlag() == true) {
            holder.heart.setImageResource(R.drawable.ic_heartfull);
        }
        if (favorArticles.get(position).getHeartFlag() == false) {
            holder.heart.setImageResource(R.drawable.ic_heart);
        }
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        View articleItem_view;
        ImageView coverImage;
        TextView artContent;
        ImageView heart;

        public ViewHolder(@NonNull View itemView, List<Article> articleList) {
            super(itemView);
            articleItem_view = itemView.findViewById(R.id.articleItem_view);
            coverImage = itemView.findViewById(R.id.article_photo);
            artContent = itemView.findViewById(R.id.article_content);
            heart = itemView.findViewById(R.id.flag);

        }
    }
}
