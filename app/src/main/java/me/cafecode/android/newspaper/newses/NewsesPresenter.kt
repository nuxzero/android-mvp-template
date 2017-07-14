package me.cafecode.android.newspaper.newses

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import me.cafecode.android.newspaper.data.NewsRepository
import javax.inject.Inject

class NewsesPresenter @Inject constructor(val repository: NewsRepository, val view: NewsesContract
.View) : NewsesContract.Presenter {

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
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
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