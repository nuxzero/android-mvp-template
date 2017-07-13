package me.cafecode.android.newspaper.data

import android.util.Log
import io.reactivex.Observable
import me.cafecode.android.newspaper.data.local.NewsLocalDataSource
import me.cafecode.android.newspaper.data.models.News
import me.cafecode.android.newspaper.data.remote.NewsRemoteDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton open class NewsRepository @Inject constructor(remoteData: NewsRemoteDataSource, localData:
NewsLocalDataSource)
    : NewsRepositoryDataSource {

    var mRemoteData = remoteData

    var mLocalData = localData

    val TAG = "NewsRepository"

    override fun loadNewses(): Observable<List<News>> {
        return mRemoteData.loadNewses()
                .flatMap { newses ->
                    Observable.fromArray(newses)
                            .doOnNext { nextNewses ->
                                mLocalData.saveNewses(nextNewses)
                            }
                }
//                .doOnError({ error -> Log.e(TAG, error.message) })
    }

}
