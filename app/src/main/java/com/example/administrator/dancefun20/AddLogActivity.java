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
import android.widget.Button;

public class AddLogActivity extends Activity {
Button addbackmenu;
Button sendlog;
Button addphoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_log);
        //---------------------------设置为状态栏为白色---------------------------------------------------------------------------------------------------------------------
        Window window = AddLogActivity.this.getWindow();
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
     addbackmenu = findViewById(R.id.addlogtomenu);
        sendlog = findViewById(R.id.signedbtn);
        addphoto = findViewById(R.id.addLogPhotobtn);
        addbackmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent();
                intent.setClass(AddLogActivity.this,FunmenuActivity.class);
                startActivity(intent);
            }
        });

        sendlog = findViewById(R.id.logsendbtn);
        sendlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent();
                intent.setClass(AddLogActivity.this,LoglistActivity
                        .class);
                startActivity(intent);

            }
        });

    }
}
