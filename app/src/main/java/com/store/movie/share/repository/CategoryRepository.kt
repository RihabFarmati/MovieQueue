package com.store.movie.share.repository

import com.store.movie.share.models.Category
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe

interface CategoryRepository {

    fun insertCategory(category: Category): Completable

    fun updateCategory(category: Category): Completable

    fun deleteCategory(category: Category): Completable

    fun getAllCategories(): Maybe<List<Category>>
}