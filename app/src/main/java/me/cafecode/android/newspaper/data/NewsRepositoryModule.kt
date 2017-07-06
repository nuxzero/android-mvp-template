package me.cafecode.android.newspaper.data

import dagger.Module
import dagger.Provides
import me.cafecode.android.newspaper.data.local.NewsLocalData
import me.cafecode.android.newspaper.data.local.NewsLocalDataSource
import me.cafecode.android.newspaper.data.remote.NewsRemoteData
import me.cafecode.android.newspaper.data.remote.NewsRemoteDataSource

@Module
class NewsRepositoryModule {

    companion object {
        val BASE_URL = "https://newsapi.org/v1/"
    }

    @Provides
    fun provideNewsRemoteData(): NewsRemoteDataSource {
        return NewsRemoteData(BASE_URL)
    }

    @Provides
    fun provideNewsLocalData(): NewsLocalDataSource {
        return NewsLocalData()
    }

}
