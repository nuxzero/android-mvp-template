package me.cafecode.android.newspaper.data.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import me.cafecode.android.newspaper.data.models.News;

@Dao
public interface NewsDao {

    @Query("SELECT * FROM news")
    List<News> getNews();

    @Insert
    void insertNews(News news);

    @Update
    void updateNews(News news);

}
