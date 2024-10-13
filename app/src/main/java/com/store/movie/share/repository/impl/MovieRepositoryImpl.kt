package com.store.movie.share.repository.impl

import com.store.movie.share.dao.MovieDao
import com.store.movie.share.models.Movie
import com.store.movie.share.repository.MovieRepository
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieDao: MovieDao
) : MovieRepository {

    override fun insertMovie(movie: Movie) {
        movieDao.insert(movie)
    }

    override fun updateMovie(movie: Movie) {
        movieDao.update(movie)
    }

    override fun deleteMovie(movie: Movie) {
        movieDao.delete(movie)
    }

    override fun getMovieById(movieId: Int): Maybe<Movie> {
        return movieDao.getMovieById(movieId)
    }

    override fun getAllMovies(): Observable<List<Movie>> {
        return movieDao.getAllMovies()
    }
}