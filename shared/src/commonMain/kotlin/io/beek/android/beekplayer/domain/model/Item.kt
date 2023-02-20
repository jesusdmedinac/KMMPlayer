package io.beek.android.beekplayer.domain.model

data class Item(
    val id: Int,
    var isComplete: Boolean,
    var summary: String,
    val ownerId: Int,
)
