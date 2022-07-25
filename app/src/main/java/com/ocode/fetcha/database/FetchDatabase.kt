package com.ocode.fetcha.database

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [FetchItemEntity::class], version = 1)
abstract class FetchDatabase : RoomDatabase() {
    abstract fun fetchDao(): FetchDao
}