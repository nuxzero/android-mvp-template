package me.cafecode.android.newspaper;

import android.app.Application;

import me.cafecode.android.newspaper.data.DaggerNewsRepositoryComponent;
import me.cafecode.android.newspaper.data.NewsRepositoryComponent;
import me.cafecode.android.newspaper.injection.AppModule;

/**
 * Created by Natthawut Hemathulin on 5/31/2017 AD.
 * Email: natthawut1991@gmail.com
 */

public class NewspaperApplication extends Application {

    private NewsRepositoryComponent mRepositoryComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mRepositoryComponent = DaggerNewsRepositoryComponent.builder()
                .appModule(new AppModule())
                .build();
    }

    public NewsRepositoryComponent getRepositoryComponent() {
        return mRepositoryComponent;
    }

}
