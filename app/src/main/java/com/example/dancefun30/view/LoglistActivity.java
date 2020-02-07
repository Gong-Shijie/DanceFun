package com.example.dancefun30.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dancefun30.R;
import com.example.dancefun30.model.Loog;
import com.example.dancefun30.pre.LoogAdapter;

import org.litepal.crud.DataSupport;

import java.util.List;

public class LoglistActivity extends AppCompatActivity {
    Button toaddlog;
    List<Loog> loogList;
    Button loglisttomenu;
    RecyclerView recyclerView;
    LoogAdapter adapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loglist);



        //添加日志：
        toaddlog = findViewById(R.id.toaddLog);
        toaddlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(LoglistActivity.this, AddLogActivity.class);
               startActivity(intent);
               inilist();
            }
        });

        loglisttomenu = findViewById(R.id.loglisttomenu);
        loglisttomenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(LoglistActivity.this, FunmenuActivity.class);
                startActivity(intent);
            }
        });

        //显示日志：
        inilist();
        recyclerView = findViewById(R.id.log_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        adapter1=null;
        LoogAdapter adapter1 =new LoogAdapter(loogList,getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter1);

    }

    public void inilist() {
        loogList = DataSupport.findAll(Loog.class);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
