package com.example.xia_day03_one;

import android.app.Application;

import com.example.xia_day03_one.dao.DaoMaster;
import com.example.xia_day03_one.dao.DaoSession;

/**
 * Created by 只想暴富 on 2019/5/29.
 */

public class Myapp extends Application {

    private static  DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "pp.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        daoSession = daoMaster.newSession();
    }
    public  static  DaoSession getDaoSession(){
        return  daoSession;
    }
}
