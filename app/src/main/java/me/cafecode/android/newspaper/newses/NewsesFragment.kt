package me.cafecode.android.newspaper.newses

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.news_item.view.*
import me.cafecode.android.newspaper.R
import me.cafecode.android.newspaper.data.models.News

class NewsesFragment : Fragment(), NewsesContract.View {

    private lateinit var presenter: NewsesContract.Presenter
    private lateinit var progressBar: ProgressBar
    private lateinit var listView: RecyclerView
    private lateinit var adapter: NewsAdapter

    companion object {

        fun newInstance(): NewsesFragment {
            return NewsesFragment()
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater!!.inflate(R.layout.fragment_newses, container, false)

        progressBar = rootView.findViewById(R.id.progress_bar)
        listView = rootView.findViewById(R.id.news_list)
        adapter = NewsAdapter(null) { news ->
            Log.i("News", news.title)
        }
        listView.adapter = adapter
        listView.layoutManager = LinearLayoutManager(context)
        return rootView
    }

    override fun onResume() {
        super.onResume()

        presenter.onStart()
    }

    override fun setPresenter(presenter: NewsesContract.Presenter) {
        this.presenter = presenter
    }

    override fun showProgressView(isShow: Boolean) {
        if (isShow) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }

    override fun showNewses(newses: List<News>) {
        Log.i("news fragment", "show news list size: " + newses.size)
        adapter.newsList = newses
        adapter.notifyDataSetChanged()
    }

    override fun showErrorMessage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    class NewsAdapter(var newsList: List<News>?, val listener: (News) -> Unit) : RecyclerView
    .Adapter<NewsAdapter
    .NewsViewHolder>() {

        override fun getItemCount(): Int {
            return newsList?.size ?: 0
        }

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): NewsViewHolder {
            val view = LayoutInflater.from(parent?.context).inflate(R.layout.news_item, parent, false)

            return NewsViewHolder(view)
        }

        override fun onBindViewHolder(holder: NewsViewHolder?, position: Int) {
            val news = newsList!![position]
            holder!!.bind(news, listener)
        }

        class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            fun bind(news: News, listener: (News) -> Unit) {
                itemView.newsTitle.text = news.title

                // Load image
                Glide.with(itemView)
                        .load(news.urlToImage)
                        .into(itemView.newsImage)

                // Click listener
                itemView.setOnClickListener { view -> listener(news) }
            }

        }

    }

}
