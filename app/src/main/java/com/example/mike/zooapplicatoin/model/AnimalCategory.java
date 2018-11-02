package com.example.mike.zooapplicatoin.model;

import android.support.annotation.NonNull;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Index;

@Entity
public class AnimalCategory {
    @NonNull
    @Id ( autoincrement = true)
    private long id;

    @NonNull
    String name;

    @Generated(hash = 355389809)
    public AnimalCategory(long id, @NonNull String name) {
        this.id = id;
        this.name = name;
    }

    @Generated(hash = 571426910)
    public AnimalCategory() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
