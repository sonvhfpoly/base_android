package com.vnextglobal.core

import androidx.paging.PagingData
import com.vnextglobal.core.model.Backdrops
import com.vnextglobal.core.model.Movie
import com.vnextglobal.core.model.MovieDetail
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    suspend fun getRecommendedMovies(): List<Movie>

    suspend fun getMovieDetail(id: Int): MovieDetail

    suspend fun getRecommendedMoviesFlow() : Flow<PagingData<Movie>>

    suspend fun getMovieBackdropImages(movieId: Int) : List<Backdrops>
}