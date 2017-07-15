package me.cafecode.android.newspaper.newses

import me.cafecode.android.newspaper.data.NewsRepository
import me.cafecode.android.newspaper.util.BaseSchedulerProvider
import javax.inject.Inject

class NewsesPresenter @Inject constructor(val repository: NewsRepository, val view:
NewsesContract.View, val schedulerProvider: BaseSchedulerProvider) : NewsesContract.Presenter {

    @Inject
    fun setupListeners() {
        view.setPresenter(this)
    }

    override fun onStart() {
        loadNewses()
    }

    override fun loadNewses() {
        view.showProgressView(true)

        repository.loadNewses()
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe(
                        { newses ->
                            view.showNewses(newses)
                            view.showProgressView(false)
                        },
                        { error ->
                            error.printStackTrace()
                            view.showProgressView(false)
                            view.showErrorMessage(error.message!!)
                        }
                )
    }

}