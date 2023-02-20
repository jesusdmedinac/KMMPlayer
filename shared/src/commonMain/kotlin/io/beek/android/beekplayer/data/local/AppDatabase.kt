package io.beek.android.beekplayer.data.local

import io.beek.android.beekplayer.data.local.model.Item
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

object AppDatabase {
    fun realm(): Realm {
        val config = RealmConfiguration.create(schema = setOf(Item::class))
        return Realm.open(config)
    }
}