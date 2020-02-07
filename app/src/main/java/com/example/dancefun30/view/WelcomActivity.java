package com.example.dancefun30.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.dancefun30.R;
import com.example.dancefun30.model.FavorArticle;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

public class WelcomActivity extends AppCompatActivity {
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom);


        imageView = findViewById(R.id.start_btn);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent();
                intent.setClass(WelcomActivity.this,LoopviewActivity.class);
                startActivity(intent);
            }
        });
    }


}
