package me.cafecode.android.newspaper.data;

import dagger.Module;
import dagger.Provides;
import me.cafecode.android.newspaper.data.remote.NewsRemoteData;

/**
 * Created by Natthawut Hemathulin on 6/2/2017 AD.
 * Email: natthawut1991@gmail.com
 */

@Module
public class NewsRepositoryModule {

    private static final String BASE_URL = "https://newsapi.org/v1/";

    @Provides
    NewsRemoteData provideNewsRemoteData() {
        return new NewsRemoteData(BASE_URL);
    }

}
