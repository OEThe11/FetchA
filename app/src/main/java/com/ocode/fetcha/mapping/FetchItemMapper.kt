package com.ocode.fetcha.mapping

import com.ocode.fetcha.database.FetchItemEntity
import com.ocode.fetcha.models.GetFetchResponseItem

object FetchItemMapper {

    fun buildFrom(response: GetFetchResponseItem): FetchItemEntity{
        return FetchItemEntity(
            id = response.id,
            listId = response.listId,
            name = response.name ?: ""
        )
    }

}