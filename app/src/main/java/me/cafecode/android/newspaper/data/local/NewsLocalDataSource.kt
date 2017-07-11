package me.cafecode.android.newspaper.data.local

import me.cafecode.android.newspaper.data.models.News

interface NewsLocalDataSource {

    fun loadNewses() : List<News>

    fun saveNewses(newses: List<News>)

}
