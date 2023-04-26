package com.example.roomdatabase.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.roomdatabase.dao.UserDao;
import com.example.roomdatabase.models.User;

@Database(entities = {User.class},version = 1)

public  abstract class DatabaseProvider extends RoomDatabase {

    //getUserDao : its implementing class that is Room will return its object that is UserDao(Interface)
    public abstract UserDao getUserDao();

    public static DatabaseProvider databaseProvider = null;

    public static DatabaseProvider getDbConnection(Context context){

        if(databaseProvider ==null ){
            databaseProvider = Room.databaseBuilder(context,DatabaseProvider.class,"MyDatabase")
                    .allowMainThreadQueries()
                    .build();
        }
        return databaseProvider;
    }


}
