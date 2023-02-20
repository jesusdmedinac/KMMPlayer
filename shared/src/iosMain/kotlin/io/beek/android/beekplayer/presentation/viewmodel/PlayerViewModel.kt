package io.beek.android.beekplayer.presentation.viewmodel

import kotlinx.coroutines.*
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.container

actual abstract class PlayerViewModel : CommonViewModel<PlayerState, PlayerSideEffect> {
    actual override val scope: CoroutineScope =
        CoroutineScope(SupervisorJob() + Dispatchers.Unconfined)

    actual override val container: Container<PlayerState, PlayerSideEffect> =
        scope.container(PlayerState())

    actual abstract fun onLoad()

    actual abstract fun retrieveItems()
}
