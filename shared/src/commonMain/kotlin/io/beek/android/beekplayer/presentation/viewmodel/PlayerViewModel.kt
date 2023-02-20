package io.beek.android.beekplayer.presentation.viewmodel

import io.beek.android.beekplayer.domain.repository.ItemRepository
import kotlinx.coroutines.CoroutineScope
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce

expect abstract class PlayerViewModel() :
    CommonViewModel<PlayerState, PlayerSideEffect> {
    override val scope: CoroutineScope

    override val container: Container<PlayerState, PlayerSideEffect>

    abstract fun onLoad()

    abstract fun retrieveItems()
}

class PlayerViewModelImpl(
    private val itemRepository: ItemRepository,
) : PlayerViewModel() {
    override fun onLoad() {
        intent {
            reduce { state.copy(hola = !state.hola) }
        }
        retrieveItems()
    }

    override fun retrieveItems() {
        intent {
            itemRepository.seedItems()
            val items = itemRepository.getItems()
                .map {
                    PlayerState.Item(
                        it.id,
                        it.isComplete,
                        it.summary,
                        it.ownerId,
                    )
                }
            reduce { state.copy(items = items) }
        }
    }
}

data class PlayerState(
    val hola: Boolean = false,
    val items: List<Item> = emptyList()
) {
    data class Item(
        val id: Int,
        var isComplete: Boolean,
        var summary: String,
        val ownerId: Int,
    )
}

sealed class PlayerSideEffect