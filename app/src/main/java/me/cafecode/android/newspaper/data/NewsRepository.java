package me.cafecode.android.newspaper.data;

import java.util.List;

import javax.inject.Inject;

import me.cafecode.android.newspaper.data.local.NewsLocalDataSource;
import me.cafecode.android.newspaper.data.models.News;
import me.cafecode.android.newspaper.data.remote.NewsRemoteDataSource;

/**
 * Created by Natthawut Hemathulin on 5/31/2017 AD.
 * Email: natthawut1991@gmail.com
 */

public class NewsRepository implements NewsRepositoryDataSource {

    private NewsRemoteDataSource mRemoteData;
    private NewsLocalDataSource mLocalData;

    @Inject
    public NewsRepository(NewsRemoteDataSource remoteData, NewsLocalDataSource localData) {
        mRemoteData = remoteData;
        mLocalData = localData;
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
