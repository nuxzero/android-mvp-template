package me.cafecode.android.newspaper.data

import dagger.Component

@Component(modules = arrayOf(NewsRepositoryModule::class))
interface NewsRepositoryComponent {

    fun getNewsRepository() : NewsRepository

}