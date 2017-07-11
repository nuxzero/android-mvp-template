package me.cafecode.android.newspaper.data.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

/**
 * Created by Nux on 7/11/2017 AD.
 */

@Entity
public class News {
    @PrimaryKey
    public String title;
    public String author;
    public String description;
    public String url;
    public String urlToImage;
//    private Date publishedAt;
}
