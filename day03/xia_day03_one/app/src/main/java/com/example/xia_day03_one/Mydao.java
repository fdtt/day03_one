package com.example.xia_day03_one;

import com.example.xia_day03_one.dao.DaoSession;
import com.example.xia_day03_one.dao.UserDao;

import java.util.List;

/**
 * Created by 只想暴富 on 2019/5/29.
 */

public class Mydao {
    public  static  User getuser(User user){
        DaoSession daoSession = Myapp.getDaoSession();
        User unique = daoSession.queryBuilder(User.class).where(UserDao.Properties.Desc.eq(user.getDesc())).build().unique();
        return  unique;
    }
    public  static  void insert(User user){
        DaoSession daoSession = Myapp.getDaoSession();
        if (getuser(user)==null){
            daoSession.insert(user);
        }
    }
    public  static  void dalete(User user){
        DaoSession daoSession = Myapp.getDaoSession();
        if (getuser(user)!=null){
            daoSession.delete(user);
        }
    }
    public  static List<User> show(){
        DaoSession daoSession = Myapp.getDaoSession();
        return  daoSession.loadAll(User.class);
    }
}
