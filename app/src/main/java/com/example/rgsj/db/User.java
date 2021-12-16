package com.example.rgsj.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "name")
    public String Name;

    @ColumnInfo(name = "email")
    public String Eamil;

    @ColumnInfo(name = "phone")
    public String Phone;

}
