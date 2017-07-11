package me.cafecode.android.newspaper.data

import io.reactivex.Observable
import me.cafecode.android.newspaper.data.local.NewsLocalDataSource
import me.cafecode.android.newspaper.data.models.News
import me.cafecode.android.newspaper.data.remote.NewsRemoteDataSource
import javax.inject.Inject

open class NewsRepository @Inject constructor(remoteData: NewsRemoteDataSource, localData:
NewsLocalDataSource)
    : NewsRepositoryDataSource {

    var mRemoteData = remoteData

    var mLocalData = localData

    override fun loadNewses(): Observable<List<News>> {
        return mRemoteData.loadNewses()
    }

}
