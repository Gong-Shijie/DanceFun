package com.example.administrator.dancefun20;



import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.administrator.dancefun20.User;


public class UserService {
    private DatabaseHelper dbHelper;
    public UserService(Context context){
        dbHelper=new DatabaseHelper(context);
    }

    public boolean login(String username,String password){
        SQLiteDatabase sdb=dbHelper.getReadableDatabase();
        String str ="";

        sdb.delete("user","username=?",new String[]{str});

        String sql="select * from user where username=? and password=?";
        Cursor cursor=sdb.rawQuery(sql, new String[]{username,password});
        if(cursor.moveToFirst()==true){
            cursor.close();

            return true;
        }
        return false;
    }
    public boolean register(User user){
        SQLiteDatabase sdb=dbHelper.getReadableDatabase();
        String sql="select * from user where username=?";
        Cursor cursor=sdb.rawQuery(sql, new String[]{user.getUsername()});
        if(cursor.moveToFirst()==false){
            cursor.close();
            String sql1="insert into user(username,email,password,journal_id) values(?,?,?,?)";
            Object obj[]={user.getUsername(),user.getEmail(),user.getPassword(),0};
            sdb.execSQL(sql1, obj);
            return true;
        }

        return false;
    }

}


