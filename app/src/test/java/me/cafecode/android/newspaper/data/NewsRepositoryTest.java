package me.cafecode.android.newspaper.data;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import io.reactivex.subscribers.TestSubscriber;
import utils.ReadJsonUtils;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Natthawut Hemathulin on 6/2/2017 AD.
 * Email: natthawut1991@gmail.com
 */

@RunWith(MockitoJUnitRunner.class)
public class NewsRepositoryTest {

    private final NewsesResponse NEWSES_RESPONSE = new ReadJsonUtils()
            .getJsonToMock("get_newses.json", NewsesResponse.class);

    private TestSubscriber<NewsesResponse> mNewsesResponseTestSubscriber = new TestSubscriber<>();

    private NewsRepository mRepository;

    @Mock
    private NewsRepositoryDataSource mRepositoryDataSource;

    @Before
    public void setUp() {

//        mRepository = new NewsRepository(mRepositoryDataSource);

    }

    @Test
    public void test() {
        assertTrue(true);
        assertNotNull(NEWSES_RESPONSE);
    }

}
