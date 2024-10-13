package com.store.movie.di

import android.app.Application
import android.content.Context
import com.store.movie.data.local.MovieDatabase
import com.store.movie.share.dao.CategoryDao
import com.store.movie.share.dao.MovieDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideApplicationContext(app: Application): Context = app

    @Provides
    @Singleton
    fun provideMovieDatabase(appContext: Context): MovieDatabase {
        return MovieDatabase.getDatabase(appContext)
    }

    @Provides
    fun provideMovieDao(db: MovieDatabase): MovieDao = db.movieDao()

    @Provides
    fun provideCategoryDao(db: MovieDatabase): CategoryDao = db.categoryDao()
}
