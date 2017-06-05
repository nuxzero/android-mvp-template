package me.cafecode.android.newspaper.newses;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
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
        mRepository.loadNewses()
                .subscribe(new Observer<List<News>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<News> newses) {
                        mView.showNewses(newses);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        mView.showProgressView(false);
                    }
                });
    }

}
