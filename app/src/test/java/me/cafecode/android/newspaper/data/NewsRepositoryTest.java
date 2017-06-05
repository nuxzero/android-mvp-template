package me.cafecode.android.newspaper.data;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import me.cafecode.android.newspaper.data.local.NewsLocalDataSource;
import me.cafecode.android.newspaper.data.models.News;
import me.cafecode.android.newspaper.data.remote.NewsRemoteDataSource;
import utils.ReadJsonUtils;

import static org.mockito.Mockito.when;

/**
 * Created by Natthawut Hemathulin on 6/2/2017 AD.
 * Email: natthawut1991@gmail.com
 */

@RunWith(MockitoJUnitRunner.class)
public class NewsRepositoryTest {

    private final NewsesResponse NEWSES_RESPONSE = new ReadJsonUtils()
            .getJsonToMock("get_newses.json", NewsesResponse.class);

    private NewsRepository mRepository;

    @Mock
    private NewsRemoteDataSource mRemoteDataSource;

    @Mock
    private NewsLocalDataSource mLocalDataSource;

    @Before
    public void setUp() {

        mRepository = new NewsRepository(mRemoteDataSource, mLocalDataSource);

    }

    @Test
    public void test() {
        TestObserver<Integer> testSubscriber = new TestObserver<>();
        Observable.just(2).subscribe(testSubscriber);

        testSubscriber.assertValue(2);
    }

    @Test
    public void loadNewses_whenLoadNewsesSuccessThenReturnNewsesResponse() {

        // Give
        final List<News> NEWSES = NEWSES_RESPONSE.getNewses();
        when(mRemoteDataSource.loadNewses()).thenReturn(Observable.just(NEWSES));

        // When
        TestObserver<List<News>> testObserver = new TestObserver<>();
        mRepository.loadNewses().subscribe(testObserver);

        // Then
        testObserver.assertValue(NEWSES);
    }

}
