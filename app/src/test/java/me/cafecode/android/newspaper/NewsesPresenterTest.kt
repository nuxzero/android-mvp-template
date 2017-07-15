package me.cafecode.android.newspaper

import io.reactivex.Observable
import me.cafecode.android.newspaper.data.NewsRepository
import me.cafecode.android.newspaper.data.remote.NewsesResponse
import me.cafecode.android.newspaper.newses.NewsesContract
import me.cafecode.android.newspaper.newses.NewsesPresenter
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import utils.ReadJsonUtils
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.plugins.RxAndroidPlugins
import me.cafecode.android.newspaper.util.ImmediateSchedulerProvider


@RunWith(MockitoJUnitRunner::class)
class NewsesPresenterTest {

    private val NEWSES_RESPONSE = ReadJsonUtils()
            .getJsonToMock("get_newses.json", NewsesResponse::class.java)

    lateinit var mPresenter: NewsesPresenter

    @Mock
    lateinit var mRepository: NewsRepository

    @Mock
    lateinit var mView: NewsesContract.View

    companion object {

        @BeforeClass
        @JvmStatic
        fun setUpClass() {
            // Override the default "out of the box" AndroidSchedulers.mainThread() Scheduler
            //
            // This is necessary here because otherwise if the static initialization block in AndroidSchedulers
            // is executed before this, then the Android SDK dependent version will be provided instead.
            //
            // This would cause a java.lang.ExceptionInInitializerError when running the test as a
            // Java JUnit test as any attempt to resolve the default underlying implementation of the
            // AndroidSchedulers.mainThread() will fail as it relies on unavailable Android dependencies.
            RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
        }

    }

    @Before
    fun setUp() {
        val scheduleProvider = ImmediateSchedulerProvider()
        mPresenter = NewsesPresenter(mRepository, mView, scheduleProvider)
    }

    @Test
    fun onStart_whenPresenterStartWithoutCachedThenShowProgressView() {
        // Give
        Mockito.`when`(mRepository.loadNewses())
                .thenReturn(Observable.just(NEWSES_RESPONSE.newses))

        // When
        mPresenter.onStart()

        // Then
        verify(mView)!!.showProgressView(true)
    }

    @Test
    fun whenLoadNewsesFinishedThenShowNewses() {
        // Give
        val newses = NEWSES_RESPONSE.newses
        Mockito.`when`(mRepository.loadNewses())
                .thenReturn(Observable.just(newses))

        // When
        mPresenter.loadNewses()

        // Then
        verify(mView)!!.showProgressView(true)

        // After load finish
        verify(mView)!!.showProgressView(false)
        verify(mView)!!.showNewses(newses)
    }

}
