package com.cai.springcloud.pojo;

import java.util.Date;

/**
 * Created by CAI_GC on 2019/5/17.
 */
public class User {
    private Long id;
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User() {

    }

    public User(Long id) {
        this.id = id;
        this.date = new Date();
    }
}
