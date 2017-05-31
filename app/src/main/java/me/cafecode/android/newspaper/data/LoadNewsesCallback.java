package me.cafecode.android.newspaper.data;

import java.util.List;

import me.cafecode.android.newspaper.data.models.News;

/**
 * Created by Natthawut Hemathulin on 5/31/2017 AD.
 * Email: natthawut1991@gmail.com
 */

public interface LoadNewsesCallback {

    void onLoadNewsesFinished(List<News> newses);

}
