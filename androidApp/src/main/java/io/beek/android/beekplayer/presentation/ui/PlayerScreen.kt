package io.beek.android.beekplayer.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import io.beek.android.beekplayer.presentation.viewmodel.PlayerState
import io.beek.android.beekplayer.presentation.viewmodel.PlayerViewModel

@Composable
fun PlayerScreen(
    playerViewModel: PlayerViewModel,
) {
    val playerState: PlayerState by playerViewModel.container.stateFlow.collectAsState()

    LaunchedEffect(Unit) {
        playerViewModel.onLoad()
    }

    Column {
        Text(text = "${playerState.hola}")
        Button(onClick = {
            playerViewModel.onLoad()
        }) {
            Text(text = "Again")
        }
        LazyColumn {
            items(playerState.items) {
                Text(it.summary)
            }
        }
    }
}