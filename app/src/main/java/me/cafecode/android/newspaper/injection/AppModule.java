package me.cafecode.android.newspaper.injection;

import dagger.Module;
import dagger.Provides;
import me.cafecode.android.newspaper.data.NewsRepository;

/**
 * Created by Natthawut Hemathulin on 5/31/2017 AD.
 * Email: natthawut1991@gmail.com
 */

@Module
public class AppModule {

    public AppModule() {

    }

    @Provides
    NewsRepository provideRepository() {
        return new NewsRepository();
    }

}
