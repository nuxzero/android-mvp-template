package me.cafecode.android.newspaper.data.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import me.cafecode.android.newspaper.data.models.News;

/**
 * Created by Nux on 7/11/2017 AD.
 */

@Dao
public interface NewsDao {
    @Query("SELECT * FROM news")
    public List<News> getNews();

    @Insert
    public void saveNews(List<News> news);

}
