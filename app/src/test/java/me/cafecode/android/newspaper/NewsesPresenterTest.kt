package me.cafecode.android.newspaper

import io.reactivex.Observable
import me.cafecode.android.newspaper.data.LoadNewsesCallback
import me.cafecode.android.newspaper.data.NewsRepository
import me.cafecode.android.newspaper.data.models.News
import me.cafecode.android.newspaper.newses.NewsesContract
import me.cafecode.android.newspaper.newses.NewsesPresenter
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentCaptor
import org.mockito.Captor
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import java.util.*

@RunWith(MockitoJUnitRunner::class)
class NewsesPresenterTest {

    lateinit var mPresenter: NewsesPresenter

    @Mock
    lateinit var mRepository: NewsRepository

    @Mock
    lateinit var mView: NewsesContract.View

    @Captor
    var mLoadNewsesCallbackCaptor: ArgumentCaptor<LoadNewsesCallback>? = null

    @Before
    fun setUp() {
        mPresenter = NewsesPresenter(mRepository, mView)
    }

    @Test
    fun onStart_whenPresenterStartWithoutCachedThenShowProgressView() {
        // Give

        // When
        mPresenter.onStart()

        // Then
        verify(mView)!!.showProgressView(true)
    }

    @Test
    fun whenLoadNewsesFinishedThenShowNewses() {
        // Give
        val newses = Arrays.asList(News(), News(), News())
        Mockito.`when`(mRepository.loadNewses()).thenReturn(Observable.just(newses))

        // When
        mPresenter.loadNewses()

        // Then
        verify(mView)!!.showProgressView(false)
        verify(mView)!!.showNewses(newses)
    }

}
