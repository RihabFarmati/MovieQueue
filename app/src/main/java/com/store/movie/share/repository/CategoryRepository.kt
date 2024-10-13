package com.store.movie.share.repository

import com.store.movie.share.models.Category
import io.reactivex.rxjava3.core.Maybe

interface CategoryRepository {

    fun insertCategory(category: Category)

    fun updateCategory(category: Category)

    fun deleteCategory(category: Category)

    fun getAllCategories(): Maybe<List<Category>>
}