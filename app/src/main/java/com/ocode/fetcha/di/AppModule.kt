package com.ocode.fetcha.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ocode.fetcha.Constants.BASE_URL
import com.ocode.fetcha.database.FetchDao
import com.ocode.fetcha.database.FetchDatabase
import com.ocode.fetcha.network.FetchApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideFetchDao(fetchDatabase: FetchDatabase): FetchDao =
        fetchDatabase.fetchDao()


    @Provides
    @Singleton
    fun provideFetchDatabase(@ApplicationContext context: Context): FetchDatabase =
        Room.databaseBuilder(
            context,
            FetchDatabase::class.java,
            "fetchInfo"
        )
            .fallbackToDestructiveMigration()
            .build()


    @Singleton
    @Provides
    fun provideFetchApi(): FetchApi{
        val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(FetchApi::class.java)



    }

}