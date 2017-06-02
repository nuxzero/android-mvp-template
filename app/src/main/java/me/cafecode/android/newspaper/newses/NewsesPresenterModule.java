package me.cafecode.android.newspaper.newses;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Natthawut Hemathulin on 6/2/2017 AD.
 * Email: natthawut1991@gmail.com
 */

@Module
public class NewsesPresenterModule {

    private NewsesContract.View mView;

    public NewsesPresenterModule(NewsesContract.View view) {
        mView = view;
    }

    @Provides
    NewsesContract.View provideNewsesContractView() {
        return mView;
    }

}
