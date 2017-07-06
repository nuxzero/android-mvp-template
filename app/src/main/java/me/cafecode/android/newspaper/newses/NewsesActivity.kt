package me.cafecode.android.newspaper.newses

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import me.cafecode.android.newspaper.NewspaperApplication
import me.cafecode.android.newspaper.R
import javax.inject.Inject

class NewsesActivity : AppCompatActivity() {

    @Inject
    lateinit var presenter: NewsesPresenter

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        setContentView(R.layout.activity_newses)

        val fragment = NewsesFragment.newInstance()

        if (savedInstanceState == null) {
            initFragment(fragment)
        }

        // Inject into newses fragment
        DaggerNewsesPresenterComponent.builder()
                .newsRepositoryComponent((application as NewspaperApplication).newsRepositoryComponent)
                .newsesPresenterModule(NewsesPresenterModule(fragment)).build()
                .inject(this)
    }

    fun initFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.newses_content, fragment)
                .commit()
    }

}