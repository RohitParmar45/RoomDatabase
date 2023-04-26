package com.example.roomdatabase.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity()
public class User {

    @PrimaryKey(autoGenerate = true)
    public int id ;

    String name , emailid , pass, mobilenum;

    public User(String name, String emailid, String pass, String mobilenum) {
        this.name = name;
        this.emailid = emailid;
        this.pass = pass;
        this.mobilenum = mobilenum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getMobilenum() {
        return mobilenum;
    }

    public void setMobilenum(String mobilenum) {
        this.mobilenum = mobilenum;
    }
}
