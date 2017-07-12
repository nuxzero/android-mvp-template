package me.cafecode.android.newspaper.data

import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import me.cafecode.android.newspaper.data.local.LocalDatabase
import me.cafecode.android.newspaper.data.local.NewsLocalData
import me.cafecode.android.newspaper.data.local.NewsLocalDataSource
import me.cafecode.android.newspaper.data.remote.NewsRemoteData
import me.cafecode.android.newspaper.data.remote.NewsRemoteDataSource
import javax.inject.Singleton

@Module
class NewsRepositoryModule(val context: Context) {

    companion object {
        val BASE_URL = "https://newsapi.org/v1/"
    }

    @Singleton
    @Provides
    fun provideNewsRemoteData(): NewsRemoteDataSource {
        return NewsRemoteData(BASE_URL)
    }

    @Singleton
    @Provides
    fun provideNewsLocalData(): NewsLocalDataSource {
        val database: LocalDatabase = Room.databaseBuilder(context, LocalDatabase::class.java,
                "news-database.db").build()

        return NewsLocalData(database)
    }

}
