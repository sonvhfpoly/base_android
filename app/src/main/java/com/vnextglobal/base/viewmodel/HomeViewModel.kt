package com.vnextglobal.base.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.vnextglobal.core.MovieRepository
import com.vnextglobal.core.UserRepository
import com.vnextglobal.core.model.Movie
import com.vnextglobal.core.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val movieRepository: MovieRepository
): ViewModel() {

    private val _uiState = MutableStateFlow<PagingData<Movie>>(PagingData.empty())
    val uiState: StateFlow<PagingData<Movie>> = _uiState

    init {
        viewModelScope.launch {

            movieRepository.getRecommendedMoviesFlow()
                .cachedIn(viewModelScope)
                .distinctUntilChanged()
                .collectLatest {
                    _uiState.value = it
                }
        }
    }

    fun getUserInfo():User = userRepository.getUserInfo()

    suspend fun getRecommendedMovies() = movieRepository.getRecommendedMovies()

    suspend fun getRecommendedMoviesFlow() = movieRepository.getRecommendedMoviesFlow()
        .cachedIn(viewModelScope)
        .distinctUntilChanged()
}