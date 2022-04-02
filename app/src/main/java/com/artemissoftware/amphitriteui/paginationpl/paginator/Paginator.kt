package com.artemissoftware.amphitriteui.paginationpl.paginator

interface Paginator<Key, Item> {
    suspend fun loadNextItems()
    fun reset()
}