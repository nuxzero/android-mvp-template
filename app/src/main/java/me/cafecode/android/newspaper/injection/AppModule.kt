package me.cafecode.android.newspaper.injection

import dagger.Module
import dagger.Provides
import me.cafecode.android.newspaper.util.BaseSchedulerProvider
import me.cafecode.android.newspaper.util.SchedulerProvider

@Module
class AppModule {

    @Provides
    fun provideScheduleProvider(): BaseSchedulerProvider {
        return SchedulerProvider()
    }

}