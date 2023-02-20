package io.beek.android.beekplayer

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform