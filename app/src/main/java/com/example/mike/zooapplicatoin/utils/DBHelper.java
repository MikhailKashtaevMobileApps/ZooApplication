package com.example.mike.zooapplicatoin.utils;

import android.content.Context;

import com.example.mike.zooapplicatoin.model.DaoMaster;
import com.example.mike.zooapplicatoin.model.DaoSession;

import org.greenrobot.greendao.database.Database;

public class DBHelper {

    public static DaoSession initDao(Context context){
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "AnimalKingdom-db");
        Database db = helper.getWritableDb();
        return new DaoMaster(db).newSession();
    }

}
