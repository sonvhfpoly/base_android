package com.vnextglobal.base.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vnextglobal.core.MovieRepository
import com.vnextglobal.core.UserRepository
import com.vnextglobal.core.model.Backdrops
import com.vnextglobal.core.model.Movie
import com.vnextglobal.core.model.MovieDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val movieRepository: MovieRepository
): ViewModel() {

    var movie:Movie? = null

    suspend fun getMovieBackdropImages(movieId: Int): List<Backdrops> =
        withContext(viewModelScope.coroutineContext) {
            movieRepository.getMovieBackdropImages(movieId)
        }

    suspend fun getMovieDetail(movieId: Int): MovieDetail =
        withContext(viewModelScope.coroutineContext){
            movieRepository.getMovieDetail(movieId)
        }
}