package com.caesar.room.repository;

import com.caesar.room.app.AppApplication;
import com.caesar.room.db.AppDatabase;
import com.caesar.room.entity.UserInfo;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;

/**
 * author : yangshaopeng.
 * Description:.....
 * 2018/12/14 23:13
 * email : yangshaopeng_it@163.com
 */
public class UserInfoRepository
{

    private static UserInfoRepository sUserInfoRepository;
    private AppDatabase mAppDatabase;
    private MediatorLiveData<List<UserInfo>> mMutableUserInfo;

    private UserInfoRepository()
    {
        mMutableUserInfo = new MediatorLiveData<>();
        mAppDatabase = AppDatabase.getInstance(AppApplication.getAppLication().getApplicationContext());
        mMutableUserInfo.addSource(mAppDatabase.queryAllUserInfo(), new Observer<List<UserInfo>>()
        {
            @Override
            public void onChanged(List<UserInfo> userInfos)
            {
                mMutableUserInfo.postValue(userInfos);
            }
        });
    }

    public static UserInfoRepository getInstance()
    {
        if (sUserInfoRepository == null)
        {
            sUserInfoRepository = new UserInfoRepository();
        }
        return sUserInfoRepository;
    }

    public LiveData<List<UserInfo>> getAllUserInfo()
    {
        return mAppDatabase.queryAllUserInfo();
    }

    public long insertUserInfo(UserInfo userInfo)
    {
        return mAppDatabase.getUserDao().insertAll(userInfo);
    }

}