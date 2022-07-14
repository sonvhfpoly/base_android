package com.vnextglobal.base.viewmodel

import androidx.lifecycle.ViewModel
import com.vnextglobal.core.MovieRepository
import com.vnextglobal.core.UserRepository
import com.vnextglobal.core.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val movieRepository: MovieRepository
): ViewModel() {

    fun getUserInfo():User = userRepository.getUserInfo()

    suspend fun getRecommendedMovies() = movieRepository.getRecommendedMovies()

    suspend fun getRecommendedMoviesFlow() = movieRepository.getRecommendedMoviesFlow()
}