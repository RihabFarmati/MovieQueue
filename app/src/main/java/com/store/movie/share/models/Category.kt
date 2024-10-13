package com.store.movie.share.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category")
class Category(
    var name: String,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}