package me.cafecode.android.newspaper.newses;

import java.util.List;

import javax.inject.Inject;

import me.cafecode.android.newspaper.data.LoadNewsesCallback;
import me.cafecode.android.newspaper.data.NewsRepository;
import me.cafecode.android.newspaper.data.models.News;

/**
 * Created by Natthawut Hemathulin on 5/31/2017 AD.
 * Email: natthawut1991@gmail.com
 */

public class NewsesPresenter implements NewsesContract.Presenter {

    private NewsesContract.View mView;

    private NewsRepository mRepository;

    @Inject
    public NewsesPresenter(NewsRepository repository, NewsesContract.View view) {
        mRepository = repository;
        mView = view;
    }

    @Override
    public void onStart() {
        mView.showProgressView(true);
    }

    @Override
    public void loadNewses() {
        mView.showProgressView(true);
        mRepository.loadNewses(new LoadNewsesCallback() {
            @Override
            public void onLoadNewsesFinished(List<News> newses) {
                mView.showProgressView(false);
                mView.showNewses(newses);
            }
        });
    }

}
