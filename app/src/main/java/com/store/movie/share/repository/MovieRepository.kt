package com.store.movie.share.repository

import com.store.movie.share.models.Movie
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable

interface MovieRepository {

    fun insertMovie(movie: Movie): Completable

    fun updateMovie(movie: Movie): Completable

    fun deleteMovie(movie: Movie): Completable

    fun getMovieById(movieId: Int): Maybe<Movie>

    fun getAllMovies(): Observable<List<Movie>>
}