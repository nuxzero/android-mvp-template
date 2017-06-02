package me.cafecode.android.newspaper.newses;

import dagger.Component;
import me.cafecode.android.newspaper.data.NewsRepositoryComponent;

/**
 * Created by Natthawut Hemathulin on 6/2/2017 AD.
 * Email: natthawut1991@gmail.com
 */

@Component(dependencies = {NewsRepositoryComponent.class}, modules = {NewsesPresenterModule.class})
public interface NewsesComponent {

    void inject(NewsesFragment fragment);

}
