package com.example.administrator.dancefun20;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignActivity extends Activity {
    private Button signtologin;
    private Button signedbtn;
    EditText username;
    EditText password;
    EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        //---------------------------设置为状态栏为白色---------------------------------------------------------------------------------------------------------------------
        Window window = SignActivity.this.getWindow();
        //取消设置透明状态栏,使 ContentView 内容不再覆盖状态栏
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorAccent));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
//------------------------------------------------------------------------------------------------------------------------------------------------
        username = (EditText) findViewById(R.id.signN_edit);
        password = (EditText) findViewById(R.id.signP_edit);
        email = (EditText) findViewById(R.id.signA_edit);
        signtologin = findViewById(R.id.signtologbtn);
        signtologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(SignActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        signedbtn = findViewById(R.id.signedbtn);
        signedbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = username.getText().toString().trim();

                String pass = password.getText().toString().trim();

                String emails = email.getText().toString().trim();

                UserService uService = new UserService(SignActivity.this);
                User user = new User();
                user.setUsername(name);
                user.setPassword(pass);
                user.setEmail(emails);
                if (uService.register(user)) {
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
