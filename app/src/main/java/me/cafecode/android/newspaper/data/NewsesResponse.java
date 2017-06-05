package me.cafecode.android.newspaper.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import me.cafecode.android.newspaper.data.models.News;

/**
 * Created by Natthawut Hemathulin on 6/2/2017 AD.
 * Email: natthawut1991@gmail.com
 */

public class NewsesResponse {

    private String status;
    private String source;
    private String sortBy;
    @SerializedName("articles")
    private List<News> newses;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public List<News> getNewses() {
        return newses;
    }

    public void setNewses(List<News> newses) {
        this.newses = newses;
    }

}
