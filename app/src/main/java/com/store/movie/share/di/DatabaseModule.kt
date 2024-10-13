package com.store.movie.share.di

import android.content.Context
import androidx.room.Room
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
    fun provideDatabase(appContext: Context): MovieDatabase {
        // Create the Room database instance
        return Room.databaseBuilder(
            appContext,
            MovieDatabase::class.java,
            "movie_database"
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideMovieDao(db: MovieDatabase): MovieDao = db.movieDao()

    @Provides
    fun provideCategoryDao(db: MovieDatabase): CategoryDao = db.categoryDao()
}
