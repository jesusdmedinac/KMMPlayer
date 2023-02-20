package io.beek.android.beekplayer.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.container

actual abstract class PlayerViewModel : ViewModel(),
    CommonViewModel<PlayerState, PlayerSideEffect> {
    actual override val scope = viewModelScope

    actual override val container: Container<PlayerState, PlayerSideEffect> =
        scope.container(PlayerState())

    actual abstract fun onLoad()

    actual abstract fun retrieveItems()
}
