package com.vnextglobal.core.di

import com.vnextglobal.core.MovieRepoImpl
import com.vnextglobal.core.MovieRepository
import com.vnextglobal.core.UserRepoImpl
import com.vnextglobal.core.UserRepository
import com.vnextglobal.core.database.BaseDatabase
import com.vnextglobal.core.network.NetworkService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object RepoModule {

    @Singleton
    @Provides
    fun provideUserRepo(baseDatabase: BaseDatabase): UserRepository{
        return UserRepoImpl(baseDatabase)
    }

    @Singleton
    @Provides
    fun provideMovieRepo(networkService: NetworkService): MovieRepository{
        return MovieRepoImpl(networkService)
    }
}