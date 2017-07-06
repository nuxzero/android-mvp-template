package me.cafecode.android.newspaper.newses

import me.cafecode.android.newspaper.data.NewsRepository
import me.cafecode.android.newspaper.data.models.News
import javax.inject.Inject

class NewsesPresenter @Inject constructor(val repository: NewsRepository, val view: NewsesContract
.View) : NewsesContract.Presenter {

    @Inject
    fun setupListeners() {
        view.setPresenter(this)
    }

    override fun onStart() {
        view.showProgressView(true)
    }

    override fun loadNewses() {
        view.showProgressView(false)

        repository.loadNewses()
                .subscribe(
                        { newses: List<News> -> view.showNewses(newses) },
                        { view.showProgressView(false) }
                )
    }

}