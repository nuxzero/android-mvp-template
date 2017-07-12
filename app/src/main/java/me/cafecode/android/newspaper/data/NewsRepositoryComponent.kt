package me.cafecode.android.newspaper.data

import dagger.Component
import javax.inject.Singleton

/**
 * This is a Dagger component. Refer to {@link NewspaperApplication} for the list of Dagger components
 * used in this application.
 * <P>
 * Even though Dagger allows annotating a {@link Component @Component} as a singleton, the code
 * itself must ensure only one instance of the class is created. This is done in {@link
 * ToDoApplication}.
 */

@Singleton
@Component(modules = arrayOf(NewsRepositoryModule::class))
interface NewsRepositoryComponent {

    fun getNewsRepository() : NewsRepository

}