package me.cafecode.android.newspaper.data;

import dagger.Module;
import dagger.Provides;
import me.cafecode.android.newspaper.data.local.NewsLocalData;
import me.cafecode.android.newspaper.data.local.NewsLocalDataSource;
import me.cafecode.android.newspaper.data.remote.NewsRemoteData;
import me.cafecode.android.newspaper.data.remote.NewsRemoteDataSource;

/**
 * Created by Natthawut Hemathulin on 6/2/2017 AD.
 * Email: natthawut1991@gmail.com
 */

@Module
public class NewsRepositoryModule {

    private static final String BASE_URL = "https://newsapi.org/v1/";

    @Provides
    NewsRemoteDataSource provideNewsRemoteData() {
        return new NewsRemoteData(BASE_URL);
    }

    @Provides
    NewsLocalDataSource provideNewsLocalData() {
        return new NewsLocalData();
    }

}
