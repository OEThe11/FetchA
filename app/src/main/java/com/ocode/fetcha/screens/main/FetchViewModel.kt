package com.ocode.fetcha.screens.main

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ocode.fetcha.database.FetchItemEntity
import com.ocode.fetcha.repository.FetchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "FetchViewModel"

@HiltViewModel
class FetchViewModel @Inject constructor(
    private val repository: FetchRepository
) : ViewModel() {

    val fetchInfoResults = repository.feeds

    val loading = mutableStateOf(false)

    init {
        getFetchList()
    }


    //loading the suspended function with a loading component
    private fun getFetchList() {
        viewModelScope.launch {
            loading.value = true
            delay(2000)
            try {
                if (repository.fetchInfo()!!.isNotEmpty()) {
                    loading.value = false
                }
            } catch (e: Exception) {
                Log.e(TAG, e.message, e.cause)
                loading.value = true
            }

        }
    }



}