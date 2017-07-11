package me.cafecode.android.newspaper.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import me.cafecode.android.newspaper.data.models.News;

@Database(entities = {News.class}, version = 1)
@TypeConverters({LocalTypeConverters.class})
public abstract class LocalDatabase extends RoomDatabase {

    public abstract NewsDao newsDao();

}
