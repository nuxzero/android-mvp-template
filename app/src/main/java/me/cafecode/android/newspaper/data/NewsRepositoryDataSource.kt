package me.cafecode.android.newspaper.data

import io.reactivex.Observable
import me.cafecode.android.newspaper.data.models.News

interface NewsRepositoryDataSource {

    fun loadNewses() : Observable<List<News>>

}