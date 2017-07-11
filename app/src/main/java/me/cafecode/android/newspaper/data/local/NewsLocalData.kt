package me.cafecode.android.newspaper.data.local

import me.cafecode.android.newspaper.data.models.News

class NewsLocalData(val localDatabase: LocalDatabase) : NewsLocalDataSource {

    override fun loadNewses(): List<News> {
        return localDatabase.newsDao().news
    }

    override fun saveNewses(newses: List<News>) {
        localDatabase.newsDao().saveNews(newses)
    }

}
