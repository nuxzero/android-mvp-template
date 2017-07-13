package me.cafecode.android.newspaper.newses

import me.cafecode.android.newspaper.BasePresenter
import me.cafecode.android.newspaper.BaseView
import me.cafecode.android.newspaper.data.models.News

interface NewsesContract {

    interface View : BaseView<Presenter> {

        fun showProgressView(isShow: Boolean)

        fun showNewses(newses: List<News>)

        fun showErrorMessage(message: String)

    }

    interface Presenter : BasePresenter {

        fun loadNewses()

    }
}