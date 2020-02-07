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
import com.example.dancefun30.model.User;
import com.example.dancefun30.pre.DbService;

public class SignActivity extends AppCompatActivity {
    private ImageView signtologin;
    private ImageView signedbtn;
    EditText username;
    EditText password;
    EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        username = (EditText) findViewById(R.id.signN_edit);
        password = (EditText) findViewById(R.id.signP_edit);
        email = (EditText) findViewById(R.id.signA_edit);
        signedbtn = findViewById(R.id.signedbtn);
        signedbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(SignActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        signtologin = findViewById(R.id.signtologbtn);
        signtologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = username.getText().toString().trim();

                String pass = password.getText().toString().trim();

                String emails = email.getText().toString().trim();



                User user = new User(name,pass,emails);
                Log.d("info","开启服务");
                DbService dbService = new DbService();
                if (dbService.addUser(user)) {
                    Intent intent = new Intent();
                    intent.setClass(SignActivity.this, LoginActivity.class);
                    startActivity(intent);
                    Toast toast = Toast.makeText(getApplicationContext(), null, Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP | Gravity.CENTER, 0, 1580);
                    toast.setText("注册成功！");
                    toast.show();
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), null, Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP | Gravity.CENTER, 0, 1520);
                    toast.setText("注册信息错误！");
                    toast.show();
                }

            }
        });


    }
}
