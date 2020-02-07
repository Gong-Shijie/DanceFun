package com.example.dancefun30.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dancefun30.R;
import com.example.dancefun30.pre.DbService;

public class LoginActivity extends AppCompatActivity {

    private ImageView tomenu_btn;
    private ImageView tosignbtn;
    private EditText username;
    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        tomenu_btn = findViewById(R.id.tomenu_btn);
        username = findViewById(R.id.account_Edit);
        password = findViewById(R.id.password_Edit);
        tomenu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = username.getText().toString();
                System.out.println(name);
                String pass = password.getText().toString();
                System.out.println(pass);
                DbService dbService = new DbService();
                if (dbService.checkUser(name, pass)) {
                    Intent intent = new Intent();
                    intent.setClass(LoginActivity.this, FunmenuActivity.class);
                    startActivity(intent);
                }
                else {
                    Log.i("TAG", "登录失败");
                    Toast toast = Toast.makeText(getApplicationContext(), null, Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP | Gravity.CENTER, 0, 1580);
                    toast.setText("登录失败！");
                    toast.show();
                }

            }
        });
        tosignbtn = findViewById(R.id.tosign_btn);
        tosignbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent();
                intent.setClass(LoginActivity.this,SignActivity.class);
                startActivity(intent);

            }
        });

    }

}




