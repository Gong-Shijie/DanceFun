package com.example.dancefun30.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.dancefun30.R;

public class Userinfo_Activity extends AppCompatActivity {
    ImageView infotomainmenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinfo_);

        infotomainmenu = findViewById(R.id.infotomainmenu);
        infotomainmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent();
                intent.setClass(Userinfo_Activity.this,MainMenuActivity.class);
                startActivity(intent);
            }
        });
    }
}
