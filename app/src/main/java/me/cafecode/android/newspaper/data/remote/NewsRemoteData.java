package me.cafecode.android.newspaper.data.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import me.cafecode.android.newspaper.data.LoadNewsesCallback;
import me.cafecode.android.newspaper.data.NewsRepositoryDataSource;
import me.cafecode.android.newspaper.data.NewsesResponse;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Natthawut Hemathulin on 6/2/2017 AD.
 * Email: natthawut1991@gmail.com
 */
public class NewsRemoteData implements NewsRepositoryDataSource {

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
    public void loadNewses(LoadNewsesCallback callback) {
        mApiService.getNewses()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<NewsesResponse>() {
                    @Override
                    public void onNext(@NonNull NewsesResponse newsesResponse) {

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
