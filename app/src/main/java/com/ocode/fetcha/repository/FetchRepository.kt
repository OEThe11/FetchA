package com.ocode.fetcha.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.ocode.fetcha.database.FetchDao
import com.ocode.fetcha.database.FetchItemEntity
import com.ocode.fetcha.mapping.FetchItemMapper
import com.ocode.fetcha.network.FetchApi
import javax.inject.Inject

class FetchRepository @Inject constructor(
    private val api: FetchApi,
    private val fetchDao: FetchDao
) {

    private val allInfoFeeds: LiveData<List<FetchItemEntity>> = fetchDao.getAllInfo()
    private val _infoFeeds: MediatorLiveData<List<FetchItemEntity>> = MediatorLiveData()
    val feeds: LiveData<List<FetchItemEntity>>
        get() = _infoFeeds

    init {
        _infoFeeds.addSource(allInfoFeeds) {
            _infoFeeds.value = it
        }
    }


    //The Filtering of null and Empty Strings happens here
    suspend fun fetchInfo(): List<FetchItemEntity>? {
        val request = api.getAllFetchInfo()
        if (request.isSuccessful) {
            val fetchItems = request.body()!!.filter {
                !it.name.isNullOrEmpty()
            }.map {
                FetchItemMapper.buildFrom(it)
            }
            fetchDao.insertAll(*fetchItems.toTypedArray())
            return fetchItems
        }
        return null
    }







}