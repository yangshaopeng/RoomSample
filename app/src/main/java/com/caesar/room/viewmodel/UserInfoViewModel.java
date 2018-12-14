package com.caesar.room.viewmodel;

import android.app.Application;

import com.caesar.room.entity.UserInfo;
import com.caesar.room.repository.UserInfoRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;

/**
 * author : yangshaopeng.
 * Description:.....
 * 2018/12/14 23:14
 * email : yangshaopeng_it@163.com
 */
public class UserInfoViewModel extends AndroidViewModel
{

    private UserInfoRepository mUserInfoRepository;
    private MediatorLiveData<List<UserInfo>> mUserInfoLiveData;

    public UserInfoViewModel(@NonNull Application application)
    {
        super(application);
        mUserInfoRepository = UserInfoRepository.getInstance();
        mUserInfoLiveData = new MediatorLiveData<>();
        mUserInfoLiveData.setValue(null);

        LiveData<List<UserInfo>> allUserInfo = mUserInfoRepository.getAllUserInfo();
        mUserInfoLiveData.addSource(allUserInfo, new Observer<List<UserInfo>>()
        {
            @Override
            public void onChanged(List<UserInfo> userInfos)
            {
                mUserInfoLiveData.setValue(userInfos);
            }
        });
    }

    public LiveData<List<UserInfo>> getAllUserInfo()
    {
        return mUserInfoLiveData;
    }

    @Override
    protected void onCleared()
    {
        super.onCleared();

    }
}