package me.cafecode.android.newspaper.newses

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.cafecode.android.newspaper.data.models.News

class NewsesFragment : Fragment(), NewsesContract.View {

    private lateinit var presenter: NewsesContract.Presenter

    companion object {

        fun newInstance(): NewsesFragment {
            return NewsesFragment()
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()

        presenter.onStart()
    }

    override fun setPresenter(presenter: NewsesContract.Presenter) {
        this.presenter = presenter
    }

    override fun showProgressView(isShow: Boolean) {
        println("showProgressView()")
    }

    override fun showNewses(newses: List<News>) {
        println("showNewses()")
    }

}