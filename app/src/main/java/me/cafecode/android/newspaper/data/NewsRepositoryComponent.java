package me.cafecode.android.newspaper.data;

import dagger.Component;
import me.cafecode.android.newspaper.injection.AppModule;

/**
 * Created by Natthawut Hemathulin on 6/2/2017 AD.
 * Email: natthawut1991@gmail.com
 */

@Component(modules = {NewsRepositoryModule.class, AppModule.class})
public interface NewsRepositoryComponent {

    NewsRepository getNewsRepository();

}
