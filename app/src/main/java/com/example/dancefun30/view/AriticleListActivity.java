package com.example.dancefun30.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dancefun30.R;
import com.example.dancefun30.model.Article;
import com.example.dancefun30.model.DataSup;
import com.example.dancefun30.pre.ArticleAdapter;

import java.util.List;

public class AriticleListActivity extends AppCompatActivity {
    Button articletomenu;
    RecyclerView recyclerView ;
    List<Article> articleList;
    ArticleAdapter articleAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ariticle_list);

        articleList = new DataSup().getArticleList();
        recyclerView = findViewById(R.id.article_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager
                (this,RecyclerView.VERTICAL,false);
        articleAdapter = new ArticleAdapter(articleList,getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(articleAdapter);

        articletomenu = findViewById(R.id.articletomenu);
        articletomenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent();
                intent.setClass(AriticleListActivity.this,FunmenuActivity.class);
                startActivity(intent);

            }
        });
    }
}
