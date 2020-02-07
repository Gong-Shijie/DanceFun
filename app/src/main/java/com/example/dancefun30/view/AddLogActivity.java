package com.example.dancefun30.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.dancefun30.R;
import com.example.dancefun30.model.Loog;

import java.io.ByteArrayOutputStream;
import java.io.File;

import static android.content.Intent.FLAG_GRANT_READ_URI_PERMISSION;

public class AddLogActivity extends AppCompatActivity {
    Button addbackmenu;
    Button sendlog;
    ImageView addphoto;
    Loog loog;
    EditText editText;
    private static final int PICK_PHOTO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_log);
        loog = new Loog();
        Log.i("gongshijie","对象创建");
        addbackmenu = findViewById(R.id.addlogtomenu);
        sendlog = findViewById(R.id.logsendbtn);
        addphoto = findViewById(R.id.addLogPhotobtn);
        addbackmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent();
                intent.setFlags(FLAG_GRANT_READ_URI_PERMISSION);
                intent.setClass(AddLogActivity.this,FunmenuActivity.class);
                startActivity(intent);
            }
        });

        editText =findViewById(R.id.editLogbtn);

        //保存log到数据库
        sendlog = findViewById(R.id.logsendbtn);
        sendlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loog.setContent(new String(String.valueOf(editText.getText())));
                Log.i("gongshijie",new String(String.valueOf(editText.getText())));
                loog.save();
                Intent intent  = new Intent();
                intent.setClass(AddLogActivity.this,FunmenuActivity.class);
                startActivity(intent);
            }
        });

        //从相册提取图片
        addphoto = findViewById(R.id.addLogPhotobtn);
        addphoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setFlags(FLAG_GRANT_READ_URI_PERMISSION);
                intent.setAction(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,PICK_PHOTO);
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case PICK_PHOTO:
                loog.setPhoto(data.getData().toString());
                Glide.with(this).load(loog.getPhoto()).into(addphoto);
        }
    }


}
