package io.beek.android.beekplayer.data.repository

import io.beek.android.beekplayer.domain.repository.ItemRepository
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.asBsonObjectId
import io.realm.kotlin.ext.query
import io.beek.android.beekplayer.data.local.model.Item as LocalItem
import io.beek.android.beekplayer.domain.model.Item as DomainItem

class ItemRepositoryImpl(
    private val realm: Realm,
) : ItemRepository {
    override fun seedItems() {
        realm.writeBlocking {
            copyToRealm(LocalItem().apply {
                summary = "Do the laundry"
                isComplete = 0
            })
        }
    }

    override fun getItems(): List<DomainItem> = realm
        .query<LocalItem>()
        .find()
        .map {
            DomainItem(
                it._id,
                it.isComplete == 1,
                it.summary,
                it.owner_id.toIntOrNull() ?: 0
            )
        }
}