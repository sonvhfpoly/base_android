package com.vnextglobal.core

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.vnextglobal.core.model.Backdrops
import com.vnextglobal.core.model.Movie
import com.vnextglobal.core.model.MovieDetail
import com.vnextglobal.core.network.NetworkService
import com.vnextglobal.core.paging.MoviePagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepoImpl @Inject internal constructor(private var networkService: NetworkService) :
    MovieRepository {

    companion object {
        private const val PAGE_SIZE = 20
    }

    private val source = MoviePagingSource(networkService)

    private val pager = Pager(
        config = PagingConfig(enablePlaceholders = false, pageSize = PAGE_SIZE),
        pagingSourceFactory = {
            source
        }
    )

    override suspend fun getRecommendedMovies(): List<Movie> {
        return networkService.discoverMovieList().results
    }

    override suspend fun getMovieDetail(id: Int): MovieDetail {
        return networkService.getMovieDetail(id = id)
    }

    override suspend fun getMovieBackdropImages(movieId: Int): List<Backdrops> {
        return networkService.getMovieImages(id = movieId).backdrops
    }

    override suspend fun getRecommendedMoviesFlow(): Flow<PagingData<Movie>> {
        return pager.flow
    }
}