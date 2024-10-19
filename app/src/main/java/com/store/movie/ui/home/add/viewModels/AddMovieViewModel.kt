package com.store.movie.ui.home.add.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.store.movie.share.models.Movie
import com.store.movie.share.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class AddMovieViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val state: MutableLiveData<Boolean> = MutableLiveData()
    fun getState(): LiveData<Boolean>  = state

    fun addMovie(movie: Movie) {
        movieRepository.insertMovie(movie)
            .doOnComplete {
                state.postValue(true)
            }
            .doOnError {
                state.postValue(false)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }
}