package com.vnextglobal.core.network

import com.vnextglobal.core.model.MovieDetail
import com.vnextglobal.core.model.MovieDiscoverResult
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

 internal interface NetworkService {

    @GET("discover/movie")
    suspend fun discoverMovieList(
                @Query("api_key") apiKey: String = NetworkConstants.API_KEY,
                @Query("page") page: Int = 1
    ):MovieDiscoverResult

    @GET("movie/{id}")
    suspend fun getMovieDetail(
        @Path("id") id: Int,
        @Query("api_key") apiKey: String = NetworkConstants.API_KEY
    ):MovieDetail
}