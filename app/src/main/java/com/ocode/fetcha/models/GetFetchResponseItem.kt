package com.ocode.fetcha.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GetFetchResponseItem(
    val id: Int,
    val listId: Int,
    val name: String?
)