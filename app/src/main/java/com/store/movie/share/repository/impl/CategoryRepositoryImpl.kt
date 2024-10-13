package com.store.movie.share.repository.impl

import com.store.movie.share.dao.CategoryDao
import com.store.movie.share.models.Category
import com.store.movie.share.repository.CategoryRepository
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private var categoryDao: CategoryDao
) : CategoryRepository {

    override fun insertCategory(category: Category): Completable {
        return categoryDao.insert(category)
    }

    override fun updateCategory(category: Category): Completable {
        return categoryDao.update(category)
    }

    override fun deleteCategory(category: Category): Completable {
        return categoryDao.delete(category)
    }

    override fun getAllCategories(): Maybe<List<Category>> {
        return categoryDao.getAllCategories()
    }
}