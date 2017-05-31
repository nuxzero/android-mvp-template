package me.cafecode.android.newspaper.newses;

import java.util.List;

import me.cafecode.android.newspaper.data.models.News;
import me.cafecode.android.newspaper.data.LoadNewsesCallback;
import me.cafecode.android.newspaper.data.NewsRepositoryDataSource;

/**
 * Created by Natthawut Hemathulin on 5/31/2017 AD.
 * Email: natthawut1991@gmail.com
 */

public class NewsesPresenter implements NewsesContract.Presenter {

    private NewsesContract.View mView;

    private NewsRepositoryDataSource mRepository;

    public NewsesPresenter(NewsRepositoryDataSource repository, NewsesContract.View view) {
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
