package com.example.dancefun30.pre;

import android.util.Log;

import com.example.dancefun30.model.User;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.List;
import java.util.Random;

public class DbService {

    public DbService() {
        //创建数据库
        LitePal.getDatabase();
       FavorIni.getInstance();
    }

    public boolean  checkUser(String account, String password) {
        boolean flag= false;
        LitePal.getDatabase();
        List<User> user = DataSupport.where("username=?", account).find(User.class);
        if (!user.isEmpty()) {
            if (user.get(0).getPassword().equals(password)) {
               flag = true;
            }
        }
        return flag;
    }



    public boolean addUser(User user ){

        Log.d("info","调用service");

        User useradd = new User();
        Random random = new Random();

        useradd.setUsername(user.getUsername());
        useradd.setPassword(user.getPassword());
        useradd.setEmail(user.getEmail());
        useradd.setId(random.nextInt());
        useradd.setJournal_id(0);

        Log.d("info",useradd.getUsername()+useradd.getPassword()+useradd.getPassword());
        user.save();



        return true;
    }


}
