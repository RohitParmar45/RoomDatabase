package com.example.roomdatabase.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.roomdatabase.models.User;

import java.util.List;

@Dao
public interface UserDao {

    //insert
    @Insert
    public  void  insert(User... users);

    //get
    @Query("SELECT * FROM USER")
    public List<User> getData();

    //delete
    @Delete
    public void delete (User user);
}
