package me.cafecode.android.newspaper.data.remote;

import me.cafecode.android.newspaper.data.NewsesResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Natthawut Hemathulin on 6/2/2017 AD.
 * Email: natthawut1991@gmail.com
 */

public interface NewsRemoteService {

    @GET("articles?source=techcrunch&sortBy=latest&apiKey=[API_KEY]")
    Call<NewsesResponse> getNewses();

}
