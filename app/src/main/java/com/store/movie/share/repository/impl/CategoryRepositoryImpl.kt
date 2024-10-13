package com.store.movie.share.repository.impl

import com.store.movie.share.dao.CategoryDao
import com.store.movie.share.models.Category
import com.store.movie.share.repository.CategoryRepository
import io.reactivex.rxjava3.core.Maybe
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private var categoryDao: CategoryDao
) : CategoryRepository {

    override fun insertCategory(category: Category) {
        categoryDao.insert(category)
    }

    override fun updateCategory(category: Category) {
        categoryDao.update(category)
    }

    override fun deleteCategory(category: Category) {
        categoryDao.delete(category)
    }

    override fun getAllCategories(): Maybe<List<Category>> {
        return categoryDao.getAllCategories()
    }
}