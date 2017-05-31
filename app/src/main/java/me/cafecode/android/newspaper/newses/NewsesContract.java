package me.cafecode.android.newspaper.newses;

import java.util.List;

import me.cafecode.android.newspaper.BasePresenter;
import me.cafecode.android.newspaper.BaseView;
import me.cafecode.android.newspaper.data.models.News;

/**
 * Created by Natthawut Hemathulin on 5/31/2017 AD.
 * Email: natthawut1991@gmail.com
 */

public interface NewsesContract {

    interface View extends BaseView {

        void showProgressView(boolean isShow);

        void showNewses(List<News> newses);

    }

    interface Presenter extends BasePresenter {

        void loadNewses();

    }

}
