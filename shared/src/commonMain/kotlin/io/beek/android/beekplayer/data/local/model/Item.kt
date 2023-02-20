package io.beek.android.beekplayer.data.local.model

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import kotlin.random.Random

class Item() : RealmObject {
    @PrimaryKey
    var _id: Int = Random.nextInt()
    var isComplete: Int = 0
    var summary: String = ""
    var owner_id: String = ""
    constructor(ownerId: String = "") : this() {
        owner_id = ownerId
    }
}
