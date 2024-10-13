package com.store.movie.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.store.movie.share.dao.CategoryDao
import com.store.movie.share.dao.MovieDao
import com.store.movie.share.models.Category
import com.store.movie.share.models.Movie

@Database(
    entities = [Movie::class, Category::class],
    version = 1
)
abstract class MovieDatabase : RoomDatabase() {

    // Abstract methods to get DAOs
    abstract fun movieDao(): MovieDao
    abstract fun categoryDao(): CategoryDao

    companion object {
        @Volatile
        private var INSTANCE: MovieDatabase? = null

        fun getDatabase(context: Context): MovieDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MovieDatabase::class.java,
                    "movie_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
