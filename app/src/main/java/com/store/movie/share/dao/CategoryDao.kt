package com.store.movie.share.dao

import androidx.room.Dao
import androidx.room.Query
import com.store.movie.share.base.BaseDao
import com.store.movie.share.models.Category
import io.reactivex.rxjava3.core.Maybe

@Dao
interface CategoryDao : BaseDao<Category> {

    @Query("SELECT * FROM category")
    fun getAllCategories() : Maybe<List<Category>>
}