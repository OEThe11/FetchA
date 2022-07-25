package com.ocode.fetcha.database

import com.google.common.collect.Range
import com.google.common.truth.Truth.assertThat
import junit.runner.Version.id


import org.junit.Test

class FetchItemEntityTest {

    @Test
    fun `id returns null`() {
        val result = FetchItemEntity(
            0, 2, "jesse"
        )
        assertThat(result.name).isNull()
    }

    @Test
    fun `name accepts a empty string`() {
        val result = FetchItemEntity(
            15, 2, " "
        )
        assertThat(result).isEqualTo(FetchItemEntity(15, 2, " "))
    }

    @Test
    fun `listId accepts a negative number`() {
        val result = FetchItemEntity(
            0, -3, " "
        )
        assertThat(result.listId).isIn(Range.atLeast(0))
    }

}