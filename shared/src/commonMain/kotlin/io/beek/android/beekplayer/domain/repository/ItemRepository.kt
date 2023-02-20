package io.beek.android.beekplayer.domain.repository

import io.beek.android.beekplayer.domain.model.Item

interface ItemRepository {
    fun seedItems()
    fun getItems(): List<Item>
}