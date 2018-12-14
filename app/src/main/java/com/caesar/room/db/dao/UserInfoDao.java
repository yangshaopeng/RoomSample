package com.caesar.room.db.dao;

import com.caesar.room.entity.UserInfo;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

/**
 * author : yangshaopeng.
 * Description:.....
 * 2018/12/14 23:12
 * email : yangshaopeng_it@163.com
 */
@Dao
public interface UserInfoDao
{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertAll(UserInfo userInfos);

    @Query("select * from UserInfo where id = :id")
    UserInfo queryById(int id);

    @Query("select * from UserInfo")
    LiveData<List<UserInfo>> queryAllUserInfo();

}