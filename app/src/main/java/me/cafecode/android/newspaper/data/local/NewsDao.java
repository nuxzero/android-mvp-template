package me.cafecode.android.newspaper.data.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import me.cafecode.android.newspaper.data.models.News;

@Dao
public interface NewsDao {
    @Query("SELECT * FROM news")
    List<News> getNews();

    @Insert
    void saveNews(List<News> news);

}
