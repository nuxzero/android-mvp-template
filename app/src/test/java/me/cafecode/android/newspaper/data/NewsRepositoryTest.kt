package me.cafecode.android.newspaper.data

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import me.cafecode.android.newspaper.data.local.NewsLocalDataSource
import me.cafecode.android.newspaper.data.models.News
import me.cafecode.android.newspaper.data.remote.NewsRemoteDataSource
import me.cafecode.android.newspaper.data.remote.NewsesResponse
import utils.ReadJsonUtils

import org.mockito.Mockito.`when`

/**
 * Created by Natthawut Hemathulin on 6/2/2017 AD.
 * Email: natthawut1991@gmail.com
 */

@RunWith(MockitoJUnitRunner::class)
class NewsRepositoryTest {

    private val NEWSES_RESPONSE = ReadJsonUtils()
            .getJsonToMock("get_newses.json", NewsesResponse::class.java)

    private var mRepository: NewsRepository? = null

    @Mock
    private val mRemoteDataSource: NewsRemoteDataSource? = null

    @Mock
    private val mLocalDataSource: NewsLocalDataSource? = null

    @Before
    fun setUp() {

        mRepository = NewsRepository(mRemoteDataSource, mLocalDataSource!!)

    }

    @Test
    fun loadNewses_whenLoadNewsesSuccessThenReturnNewsesResponse() {

        // Give
        val NEWSES = NEWSES_RESPONSE.newses
        `when`(mRemoteDataSource!!.loadNewses()).thenReturn(Observable.just(NEWSES))

        // When
        val testObserver = TestObserver<List<News>>()
        mRepository!!.loadNewses().subscribe(testObserver)

        // Then
        testObserver.assertValue(NEWSES)
    }

}
