package me.cafecode.android.newspaper.data.models;

import java.util.Date;

/**
 * Created by Natthawut Hemathulin on 5/31/2017 AD.
 * Email: natthawut1991@gmail.com
 */

public class News {
    /**
     * author : John Biggs
     * title : Let’s meet next week in Reykjavik
     * description : I'll be in Reykjavik next week and you know what that means... I want to meet you! So we'll be holding an small meetup (not really a pitchoff but feel free to..
     * url : https://techcrunch.com/2017/05/22/lets-meet-next-week-in-reykjavik/
     * urlToImage : https://tctechcrunch2011.files.wordpress.com/2014/05/iceland.jpg?w=728&h=400&crop=1
     * publishedAt : 2017-05-23T03:37:33Z
     */

    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private Date publishedAt;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Date publishedAt) {
        this.publishedAt = publishedAt;
    }
}
