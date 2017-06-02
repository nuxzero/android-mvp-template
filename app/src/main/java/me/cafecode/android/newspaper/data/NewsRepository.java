package me.cafecode.android.newspaper.data;

import java.util.List;

import javax.inject.Inject;

import me.cafecode.android.newspaper.data.models.News;
import me.cafecode.android.newspaper.data.remote.NewsRemoteData;

/**
 * Created by Natthawut Hemathulin on 5/31/2017 AD.
 * Email: natthawut1991@gmail.com
 */

public class NewsRepository implements NewsRepositoryDataSource {

    private NewsRemoteData mRemoteData;

    @Inject
    public NewsRepository(NewsRemoteData remoteData) {
        mRemoteData = remoteData;
    }

    @Override
    public void loadNewses(LoadNewsesCallback callback) {
        mRemoteData.loadNewses(new LoadNewsesCallback() {
            @Override
            public void onLoadNewsesFinished(List<News> newses) {

            }
        });
    }

}
