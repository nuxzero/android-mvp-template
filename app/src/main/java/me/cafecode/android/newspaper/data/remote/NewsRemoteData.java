package me.cafecode.android.newspaper.data.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import me.cafecode.android.newspaper.data.NewsesResponse;
import me.cafecode.android.newspaper.data.models.News;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Natthawut Hemathulin on 6/2/2017 AD.
 * Email: natthawut1991@gmail.com
 */
public class NewsRemoteData implements NewsRemoteDataSource {

    private final NewsRemoteService mApiService;

    public NewsRemoteData(String baseUrl) {
        OkHttpClient client = new OkHttpClient();

        final Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();

        mApiService = retrofit.create(NewsRemoteService.class);
    }

    @Override
    public Observable<List<News>> loadNewses() {
        return mApiService.getNewses()
                .flatMap(new Function<NewsesResponse, ObservableSource<List<News>>>() {
                    @Override
                    public ObservableSource<List<News>> apply(@NonNull NewsesResponse newsesResponse) throws Exception {
                        return Observable.just(newsesResponse.getNewses());
                    }
                });
    }

}
