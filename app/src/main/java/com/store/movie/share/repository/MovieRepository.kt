package com.store.movie.share.repository

import com.store.movie.share.models.Movie
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable

interface MovieRepository {

    fun insertMovie(movie: Movie)

    fun updateMovie(movie: Movie)

    fun deleteMovie(movie: Movie)

    fun getMovieById(movieId: Int): Maybe<Movie>

    fun getAllMovies(): Observable<List<Movie>>
}