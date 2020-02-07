package com.example.dancefun30.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dancefun30.R;
import com.example.dancefun30.model.DataSup;
import com.example.dancefun30.pre.MyfavorAdapter;

import java.util.List;

public class MyfavorActivity extends AppCompatActivity {
    Button myfavortomenu;
    RecyclerView recyclerView ;
    MyfavorAdapter myfavorAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myfavor);

        myfavortomenu = findViewById(R.id.myfavortomenu);
        myfavortomenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent();
                intent.setClass(MyfavorActivity.this,MainMenuActivity.class);
                startActivity(intent);
            }
        });



        recyclerView = findViewById(R.id.favArticle_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager
                (this,RecyclerView.VERTICAL,false);
        DataSup dataSup = new DataSup();
        MyfavorAdapter myfavorAdapter = new MyfavorAdapter
                (dataSup.getArticleList(),getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(myfavorAdapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
