package com.store.movie.share.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "movie")
class Movie(
    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "category_id")
    var categoryId: Long,

    @ColumnInfo(name = "note")
    var note: String,

    @ColumnInfo(name = "user_rate")
    var userRate: Int?,

    @ColumnInfo(name = "is_watched")
    var isWatched: Boolean = false,

    @ColumnInfo(name = "image_path")
    var imagePath: String?
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
