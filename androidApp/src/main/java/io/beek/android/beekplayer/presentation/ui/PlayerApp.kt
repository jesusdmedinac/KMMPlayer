package io.beek.android.beekplayer.presentation.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.beek.android.beekplayer.data.local.AppDatabase
import io.beek.android.beekplayer.data.repository.ItemRepositoryImpl
import io.beek.android.beekplayer.presentation.viewmodel.PlayerViewModel
import io.beek.android.beekplayer.presentation.viewmodel.PlayerViewModelImpl

@Composable
fun PlayerApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "player-screen") {
        composable("player-screen") {
            val playerViewModel: PlayerViewModel = viewModel(initializer = {
                PlayerViewModelImpl(
                    itemRepository = ItemRepositoryImpl(AppDatabase.realm())
                )
            })
            PlayerScreen(
                playerViewModel
            )
        }
    }
}