package me.cafecode.android.newspaper.data

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import junit.framework.Assert
import me.cafecode.android.newspaper.data.local.LocalDatabase
import me.cafecode.android.newspaper.data.local.NewsLocalData
import me.cafecode.android.newspaper.data.remote.NewsesResponse
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import utils.ReadJsonUtils

@RunWith(AndroidJUnit4::class)
class NewsLocalDataTest {

    private val newsesResponse = ReadJsonUtils().getJsonToMock("get_newses.json",
            NewsesResponse::class.java)

    private lateinit var localData: NewsLocalData

    private lateinit var database: LocalDatabase

    @Before
    fun setUp() {
        val context = InstrumentationRegistry.getTargetContext()

        database = Room.inMemoryDatabaseBuilder(context, LocalDatabase::class.java).build()

        localData = NewsLocalData(database)
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun loadNewses_whenLoadNewsesThenReturnNewses() {
        // Give
        database.newsDao().saveNews(newsesResponse.newses)

        // When
        val actualNewses = localData.loadNewses()

        // Then
        Assert.assertEquals(newsesResponse.newses.size, actualNewses.size)
    }

}