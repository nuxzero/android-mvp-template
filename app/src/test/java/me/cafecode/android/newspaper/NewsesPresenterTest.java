package me.cafecode.android.newspaper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import me.cafecode.android.newspaper.data.LoadNewsesCallback;
import me.cafecode.android.newspaper.data.NewsRepository;
import me.cafecode.android.newspaper.data.models.News;
import me.cafecode.android.newspaper.newses.NewsesContract;
import me.cafecode.android.newspaper.newses.NewsesPresenter;

import static org.mockito.Mockito.verify;

/**
 * Created by Natthawut Hemathulin on 5/31/2017 AD.
 * Email: natthawut1991@gmail.com
 */

@RunWith(MockitoJUnitRunner.class)
public class NewsesPresenterTest {

    private NewsesPresenter mPresenter;

    @Mock
    NewsRepository mRepository;

    @Mock
    NewsesContract.View mView;

    @Captor
    ArgumentCaptor<LoadNewsesCallback> loadNewsesCallbackCaptor;

    @Before
    public void setUp() {
        mPresenter = new NewsesPresenter(mRepository, mView);
    }

    @Test
    public void onStart_whenPresenterStartWithoutCachedThenShowProgressView() {
        // Give

        // When
        mPresenter.onStart();

        // Then
        verify(mView).showProgressView(true);
    }

    @Test
    public void whenLoadNewsesFinishedThenShowNewses() {
        // Give
        List<News> newses = Arrays.asList(new News(), new News(), new News());

        // When
        mPresenter.loadNewses();

        verify(mView).showProgressView(true);

        // Callback
        verify(mRepository).loadNewses(loadNewsesCallbackCaptor.capture());
        loadNewsesCallbackCaptor.getValue().onLoadNewsesFinished(newses);

        // Then
        verify(mView).showProgressView(false);
        verify(mView).showNewses(newses);
    }
}
