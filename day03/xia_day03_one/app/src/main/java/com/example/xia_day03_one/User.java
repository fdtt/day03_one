package com.example.xia_day03_one;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 只想暴富 on 2019/5/29.
 */
@Entity
public class User {
    @Id
    private Long id;
    private int url;
    private String desc;
    @Generated(hash = 1070846572)
    public User(Long id, int url, String desc) {
        this.id = id;
        this.url = url;
        this.desc = desc;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getUrl() {
        return this.url;
    }
    public void setUrl(int url) {
        this.url = url;
    }
    public String getDesc() {
        return this.desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    

}
