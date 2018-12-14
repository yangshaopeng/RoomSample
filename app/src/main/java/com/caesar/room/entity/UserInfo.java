package com.caesar.room.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * author : yangshaopeng.
 * Description:.....
 * 2018/11/25 22:37
 * email : yangshaopeng_it@163.com
 */

@Entity
public class UserInfo
{

    @PrimaryKey
    private int id;
    @ColumnInfo(name = "age")
    private int age;
    @ColumnInfo(name = "name")
    private String name;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
