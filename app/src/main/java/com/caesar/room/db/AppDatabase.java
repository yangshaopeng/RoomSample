package com.caesar.room.db;

import android.content.Context;
import android.util.Log;

import com.caesar.room.db.dao.UserInfoDao;
import com.caesar.room.entity.UserInfo;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * author : yangshaopeng.
 * Description:.....
 * 2018/12/14 23:11
 * email : yangshaopeng_it@163.com
 */
@Database(entities = {UserInfo.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase
{

    private static final String DATABASE_NAME = "info_db";

    private static AppDatabase sAppDatabase;

    public abstract UserInfoDao getUserDao();

    public static AppDatabase getInstance(Context context)
    {
        if (sAppDatabase == null)
        {
            sAppDatabase = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME).build();
        }
        return sAppDatabase;
    }

    public long insertUserInfo(UserInfo userInfos)
    {
        return sAppDatabase.getUserDao().insertAll(userInfos);
    }

    public void queryUserInfo(int id)
    {
        UserInfo userInfo = sAppDatabase.getUserDao().queryById(id);
        if (userInfo != null)
        {
            Log.d("yang", "id: " + userInfo.getId() + " name: " + userInfo.getName() + " age: " + userInfo.getAge());
        }
        else
        {
            Log.d("yang", "userinfo is null");
        }
    }

    public LiveData<List<UserInfo>> queryAllUserInfo()
    {
        return sAppDatabase.getUserDao().queryAllUserInfo();
    }

}