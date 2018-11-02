package com.example.mike.zooapplicatoin.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

import java.io.ByteArrayOutputStream;

@Entity
public class Animal {

    @NotNull
    private String animalName;

    @NonNull
    private byte[] animalPhoto;

    @NonNull
    private float weight;

    @NonNull
    @ToOne
    private AnimalCategory animalCategory;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1746493452)
    private transient AnimalDao myDao;

    @Generated(hash = 1684909865)
    public Animal(@NotNull String animalName, @NotNull byte[] animalPhoto,
            float weight) {
        this.animalName = animalName;
        this.animalPhoto = animalPhoto;
        this.weight = weight;
    }

    @Generated(hash = 308569294)
    public Animal() {
    }

    public String getAnimalName() {
        return this.animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public byte[] getAnimalPhoto() {
        return this.animalPhoto;
    }

    public void setAnimalPhoto(byte[] animalPhoto) {
        this.animalPhoto = animalPhoto;
    }

    public float getWeight() {
        return this.weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Generated(hash = 1981228337)
    private transient boolean animalCategory__refreshed;

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 332685230)
    public AnimalCategory getAnimalCategory() {
        if (animalCategory != null || !animalCategory__refreshed) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            AnimalCategoryDao targetDao = daoSession.getAnimalCategoryDao();
            targetDao.refresh(animalCategory);
            animalCategory__refreshed = true;
        }
        return animalCategory;
    }

    /** To-one relationship, returned entity is not refreshed and may carry only the PK property. */
    @Generated(hash = 224269002)
    public AnimalCategory peakAnimalCategory() {
        return animalCategory;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 600863365)
    public void setAnimalCategory(@NotNull AnimalCategory animalCategory) {
        if (animalCategory == null) {
            throw new DaoException(
                    "To-one property 'animalCategory' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.animalCategory = animalCategory;
            animalCategory__refreshed = true;
        }
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1486695615)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getAnimalDao() : null;
    }

}
