package com.example.dancefun30.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.dancefun30.R;
import com.google.android.material.navigation.NavigationView;

import static android.content.Intent.FLAG_GRANT_READ_URI_PERMISSION;

public class FunmenuActivity extends AppCompatActivity {

    private static final int PICK_VIDEO = 4;
    ImageView menulog;
    ImageView menutoarticle;
    ImageView menu_practice;
    ImageView menu_video;
    ImageView menu_play;
    Button toMain_btn;
    private static final int CAMERA_PREVIEW = 1;
    private static final int RECORD_VIDEO = 2;
    private static final int PLAY_VIDEO = 3;
    private DrawerLayout mDrawerLayout;

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        float x1 = 0;
//        float x2 = 0;
//        float y1 = 0;
//        float y2 = 0;
//        //继承了Activity的onTouchEvent方法，直接监听点击事件
//        if (event.getAction() == MotionEvent.ACTION_DOWN) {
//            //当手指按下的时候
//            x1 = event.getX();
//            Log.i("gong","x1:"+x1);
//            y1 = event.getY();
//
//            Log.i("gong","y1:"+y1);
//        }
//        if (event.getAction() == MotionEvent.ACTION_UP) {
//            //当手指离开的时候
//            x2 = event.getX();
//            Log.i("gong","x2:"+x2);
//            y2 = event.getY();
//            Log.i("gong","y2:"+y2);
//            if (y1 - y2 > 50) {
////                Toast.makeText(MainActivity.this, "向上滑", Toast.LENGTH_SHORT).show();
//            } else if (y2 - y1 > 50) {
////                Toast.makeText(MainActivity.this, "向下滑", Toast.LENGTH_SHORT).show();
//            } else if (x1 - x2 > 50) {
////                Toast.makeText(MainActivity.this, "向左滑", Toast.LENGTH_SHORT).show();
//            } else if (x2 - x1 > 50) {
////                Toast.makeText(MainActivity.this, "向右滑", Toast.LENGTH_SHORT).show();
//                Log.i("gong","滑动");
//                mDrawerLayout.openDrawer(GravityCompat.START);
//            }
//            return  true;
//        }
//
//        return super.onTouchEvent(event);
//    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funmenu);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navView = findViewById(R.id.nav_view);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }

        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.mainmenu_1:
                        Intent intent = new Intent();
                        intent.setClass(FunmenuActivity.this, Userinfo_Activity.class);
                        startActivity(intent);
                        break;
                    case R.id.mainmenu_2:
                        Intent intent2 = new Intent();
                        intent2.setClass(FunmenuActivity.this, MyfavorActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.mainmenu_3:
                        Intent intent3 = new Intent();
                        intent3.setClass(FunmenuActivity.this, LoginActivity.class);
                        startActivity(intent3);
                        break;
                    default:




                        break;

                }

                return true;
            }
        });


        mDrawerLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float x1 = 0;
                float x2 = 0;
                float y1 = 0;
                float y2 = 0;
                //继承了Activity的onTouchEvent方法，直接监听点击事件
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    //当手指按下的时候
                    x1 = event.getX();
                    Log.i("gong", "Dra:x1:" + x1);
                    y1 = event.getY();

                    Log.i("gong", "Dra: y1:" + y1);
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    //当手指离开的时候
                    x2 = event.getX();
                    if(x2>100){
                        x2=x2-600;
                        //通过修正x2来增加灵敏度
                    }
                    Log.i("gong", "Dra:x2:" + x2);
                    y2 = event.getY();
                    if(x2>100){
                        x1=x1-600;
                    }
                    Log.i("gong", "Dra:y2:" + y2);

                if (x2 - x1 > 50) {
//                Toast.makeText(MainActivity.this, "向右滑", Toast.LENGTH_SHORT).show();
                    Log.i("gong", "Dra: 滑动");

                    mDrawerLayout.openDrawer(GravityCompat.START);

                }else{
                    Log.i("gong", "Dra: 关闭抽屉");
                    mDrawerLayout.closeDrawers();
                }
                }
                return FunmenuActivity.super.onTouchEvent(event);
            }

        });


        //菜单到日志
        menulog = findViewById(R.id.menu_log);
        menulog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setFlags(FLAG_GRANT_READ_URI_PERMISSION);
                intent.setClass(FunmenuActivity.this, LoglistActivity.class);
                startActivity(intent);
            }
        });
        //菜单到文章
        menutoarticle = findViewById(R.id.menu_article);
        menutoarticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(FunmenuActivity.this, AriticleListActivity.class);
                startActivity(intent);

            }
        });

        //菜单到录像
        menu_video = findViewById(R.id.menu_video);
        menu_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //判断是否授权这里以一个权限为例
                if (ContextCompat.checkSelfPermission(FunmenuActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    //没有授权进行权限申请
                    ActivityCompat.requestPermissions(FunmenuActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO}, RECORD_VIDEO);
                } else {

                    recordVideo();
                }
            }
        });

        //菜单到播放
        menu_play = findViewById(R.id.menu_play);
        menu_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //判断是否授权这里以一个权限为例
                if (ContextCompat.checkSelfPermission(FunmenuActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    //没有授权进行权限申请
                    ActivityCompat.requestPermissions(FunmenuActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO}, PICK_VIDEO);
                } else {
                    pickvideo();
                }
            }
        });

        //菜单到相机预览
        menu_practice = findViewById(R.id.menu_practice);
        menu_practice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //判断是否授权这里以一个权限为例
                if (ContextCompat.checkSelfPermission(FunmenuActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    //没有授权进行权限申请
                    ActivityCompat.requestPermissions(FunmenuActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO}, CAMERA_PREVIEW);
                } else {
                    openpreview();
                }
            }
        });


    }


    //授权后的操作
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case RECORD_VIDEO:
                recordVideo();
                break;
            case PICK_VIDEO:
                pickvideo();
                break;
            case CAMERA_PREVIEW:
                openpreview();
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK) {
            return;
        }
        switch (requestCode) {
            case PICK_VIDEO:
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(data.getData());
                intent.addFlags(FLAG_GRANT_READ_URI_PERMISSION);
                startActivity(intent);
                break;
        }
    }


    public void openpreview() {
        Intent intent = new Intent(FunmenuActivity.this, PreviewActivity.class);
        startActivity(intent);
    }


    public void recordVideo() {
        Intent intent = new Intent(MediaStore.INTENT_ACTION_VIDEO_CAMERA);
        startActivityForResult(intent, 3);
    }

    public void pickvideo() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("video/*");
        startActivityForResult(intent, PICK_VIDEO);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
        }
        return true;
    }
}
