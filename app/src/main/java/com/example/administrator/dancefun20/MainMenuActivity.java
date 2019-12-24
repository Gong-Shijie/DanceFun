package com.example.administrator.dancefun20;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class MainMenuActivity extends Activity {
private ImageView tologin_btn;
private ImageView toFunbtn;
private ImageView toUserinfo;
private ImageView tomyfavor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //---------------------------设置为状态栏为白色---------------------------------------------------------------------------------------------------------------------
        Window window = MainMenuActivity.this.getWindow();
        //取消设置透明状态栏,使 ContentView 内容不再覆盖状态栏
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(this,R.color.colorAccent));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
//------------------------------------------------------------------------------------------------------------------------------------------------
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
