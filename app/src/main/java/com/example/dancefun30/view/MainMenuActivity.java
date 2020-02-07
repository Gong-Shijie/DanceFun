package com.example.dancefun30.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.dancefun30.R;

public class MainMenuActivity extends AppCompatActivity {
    private ImageView tologin_btn;
    private Button toFunbtn;
    private ImageView toUserinfo;
    private ImageView tomyfavor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        tologin_btn = findViewById(R.id.mainmenu_3);
        tologin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent();
                intent.setClass(MainMenuActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        toFunbtn = findViewById(R.id.backFunbtn);
        toFunbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent();
                intent.setClass(MainMenuActivity.this,FunmenuActivity.class);
                startActivity(intent);
            }
        });
        toUserinfo = findViewById(R.id.mainmenu_1);
        toUserinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent();
                intent.setClass(MainMenuActivity.this,Userinfo_Activity.class);
                startActivity(intent);

            }
        });

        tomyfavor = findViewById(R.id.mainmenu_2);
        tomyfavor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent();
                intent.setClass(MainMenuActivity.this,MyfavorActivity.class);
                startActivity(intent);

            }
        });
    }


}
