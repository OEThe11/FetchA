package com.ocode.fetcha.database

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.ocode.fetcha.getOrAwaitValue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class FetchDaoTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: FetchDatabase
    private lateinit var dao: FetchDao

    @Before
    fun setup(){
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            FetchDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.fetchDao()
    }

    @After
    fun teardown(){
        database.close()
    }

    @Test
    fun insertFetchItem() = runTest {
        val fetchItem = FetchItemEntity(1, 3, "name")
        dao.insertAll(fetchItem)

        val allFetchItems = dao.getAllInfo().getOrAwaitValue()

        assertThat(allFetchItems).contains(fetchItem)
    }

    @Test
    fun insertFetchItemWithEmptyString() = runTest {
        val fetchItem = FetchItemEntity(2, 2, "")
        dao.insertAll(fetchItem)

        val allFetchItems = dao.getAllInfo().getOrAwaitValue()

        assertThat(allFetchItems).contains(fetchItem)
    }
}