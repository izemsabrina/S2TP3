package fr.doranco.flash.dao;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import fr.doranco.flash.entity.User;

@Database(entities = {User.class},version = 1)
public abstract class DaoFactory extends RoomDatabase {

    private static final String NOM_BD= "DORANCO_ROM";

    private static DaoFactory daoFactory;

    public static DaoFactory getInstance(Context context){
        if (daoFactory==null) {
            daoFactory= Room
                    .databaseBuilder(context, DaoFactory.class,NOM_BD)
                    .allowMainThreadQueries()//attention de faire ca en production
                    .build();
        }
        return  daoFactory;
    }
    public  abstract UserDao getUserDao();
}
