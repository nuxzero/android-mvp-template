package me.cafecode.android.newspaper.data.remote;

import java.util.List;

import io.reactivex.Observable;
import me.cafecode.android.newspaper.data.models.News;

/**
 * Created by Natthawut Hemathulin on 6/3/2017 AD.
 * Email: natthawut1991@gmail.com
 */

public interface NewsRemoteDataSource {

    Observable<List<News>> loadNewses();

}
