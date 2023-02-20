package io.beek.android.beekplayer.utils.coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged

class CommonFlow<T : Any>(private val source: Flow<T>, private val scope: CoroutineScope) {
    fun collect(
        onCollect: (T) -> Unit,
        onCompletion: () -> Unit,
        onException: (Throwable) -> Unit
    ) {
        scope.launch {
            try {
                source
                    .distinctUntilChanged()
                    .collect {
                    println("dani collect")
                    onCollect(it)
                }

                println("dani complete")
                onCompletion()
            } catch (t: Throwable) {
                println("dani catch ${t.message}")
                onException(t)
            }
        }
    }
}