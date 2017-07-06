package me.cafecode.android.newspaper.newses

import dagger.Component
import me.cafecode.android.newspaper.data.NewsRepositoryComponent

@Component(modules = arrayOf(NewsesPresenterModule::class),
        dependencies = arrayOf(NewsRepositoryComponent::class))
interface NewsesPresenterComponent {

    fun inject(fragment: NewsesActivity)

}
