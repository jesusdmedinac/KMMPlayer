package io.beek.android.beekplayer.utils.coroutines

import platform.posix.usleep

actual fun commonDelay(timeInMillis: Long) {
    usleep(timeInMillis.toUInt() * 1000L.toUInt())
}