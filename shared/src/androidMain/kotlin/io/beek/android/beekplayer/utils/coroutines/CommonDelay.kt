package io.beek.android.beekplayer.utils.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

actual fun commonDelay(timeInMillis: Long) {
    runBlocking {
        delay(timeInMillis)
    }
}