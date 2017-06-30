package me.cafecode.android.newspaper.data.remote;

import io.reactivex.Observable;
import me.cafecode.android.newspaper.data.NewsesResponse;
import retrofit2.http.GET;

/**
 * Created by Natthawut Hemathulin on 6/2/2017 AD.
 * Email: natthawut1991@gmail.com
 */

public interface NewsRemoteService {

    @GET("articles?source=techcrunch&sortBy=latest&apiKey=691700b86fee41c58f6cee530e91623b")
    Observable<NewsesResponse> getNewses();

}
