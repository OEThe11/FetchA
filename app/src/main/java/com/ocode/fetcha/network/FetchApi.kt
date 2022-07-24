package com.ocode.fetcha.network

import com.ocode.fetcha.Constants.ENDPOINT
import com.ocode.fetcha.models.GetFetchResponseItem
import retrofit2.Response
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface FetchApi {
    @GET(ENDPOINT)
    suspend fun getAllFetchInfo(): Response<List<GetFetchResponseItem>>
}