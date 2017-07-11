package me.cafecode.android.newspaper.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import me.cafecode.android.newspaper.data.models.News;

@Database(entities = {News.class}, version = 1)
public abstract class LocalDatabase extends RoomDatabase {

    public abstract NewsDao newsDao();

}
