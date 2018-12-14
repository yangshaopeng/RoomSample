package com.caesar.room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.caesar.room.entity.UserInfo;
import com.caesar.room.repository.UserInfoRepository;
import com.caesar.room.viewmodel.UserInfoViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button button;
    private MutableLiveData<String> mutableLiveData;
    private UserInfoViewModel mUserInfoViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text);
        button = findViewById(R.id.button);
        mutableLiveData = new MutableLiveData<>();

        mUserInfoViewModel = ViewModelProviders.of(this).get(UserInfoViewModel.class);

        updateUi(mUserInfoViewModel.getAllUserInfo());
    }

    private void updateUi(LiveData<List<UserInfo>> userInfoLiveData)
    {
        userInfoLiveData.observe(this, new Observer<List<UserInfo>>()
        {
            @Override
            public void onChanged(List<UserInfo> userInfos)
            {
                if (userInfos == null)
                {
                    Log.e("yang", "user infos is null");
                }
                else
                {
                    for (UserInfo userInfo : userInfos)
                    {
                        Log.i("yang", "111id: "
                                + userInfo.getId()
                                + "; name:"
                                + userInfo.getName()
                                + ";age: "
                                + userInfo.getAge());
                    }
                }
            }
        });
    }

    int id = 2;

    public void click(View view)
    {
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                UserInfo userInfo = new UserInfo();
                userInfo.setId(id);
                userInfo.setAge(id);
                userInfo.setName(id * 11 + "");
                UserInfoRepository.getInstance().insertUserInfo(userInfo);
                id++;
            }
        }).start();
    }
}
