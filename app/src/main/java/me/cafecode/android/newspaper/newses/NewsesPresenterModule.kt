package me.cafecode.android.newspaper.newses

import dagger.Module
import dagger.Provides

@Module
class NewsesPresenterModule(val view: NewsesContract.View) {

    @Provides
    fun provideNewsesContractView(): NewsesContract.View {
        return view
    }

}