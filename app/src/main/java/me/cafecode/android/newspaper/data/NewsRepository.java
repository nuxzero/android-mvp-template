package me.cafecode.android.newspaper.data;

import javax.inject.Inject;

/**
 * Created by Natthawut Hemathulin on 5/31/2017 AD.
 * Email: natthawut1991@gmail.com
 */

public class NewsRepository implements NewsRepositoryDataSource {

    @Inject
    public NewsRepository() {
    }

    @Override
    public void loadNewses(LoadNewsesCallback callback) {

    }

}
