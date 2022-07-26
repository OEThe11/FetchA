package com.ocode.fetcha.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface FetchDao {
    @Query("SELECT * FROM fetch_entity ORDER BY listId ASC")
    fun getAllInfo(): LiveData<List<FetchItemEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg info: FetchItemEntity)

}