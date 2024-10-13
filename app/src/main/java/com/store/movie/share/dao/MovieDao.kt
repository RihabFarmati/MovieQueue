package com.store.movie.share.dao


import androidx.room.Dao
import androidx.room.Query
import com.store.movie.share.base.BaseDao
import com.store.movie.share.models.Movie
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable

@Dao
interface MovieDao : BaseDao<Movie> {

    @Query("SELECT * FROM movie")
    fun getAllMovies(): Observable<List<Movie>>

    @Query("SELECT * FROM movie WHERE id = :movieId LIMIT 1")
    fun getMovieById(movieId: Int): Maybe<Movie>
}
