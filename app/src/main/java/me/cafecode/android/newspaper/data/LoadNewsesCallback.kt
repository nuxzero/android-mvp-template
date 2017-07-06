package me.cafecode.android.newspaper.data

import me.cafecode.android.newspaper.data.models.News

interface LoadNewsesCallback {

    fun onLoadNewsesFinished(newses: List<News>)

}
