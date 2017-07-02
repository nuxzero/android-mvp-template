package me.cafecode.android.newspaper.data.remote

import io.reactivex.Observable
import me.cafecode.android.newspaper.data.models.News

interface NewsRemoteDataSource {

    fun loadNewses(): Observable<List<News>>

}