package com.vnextglobal.core.di

import com.vnextglobal.core.UserRepoImpl
import com.vnextglobal.core.UserRepository
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
    fun provideUserRepo(repoImpl: UserRepoImpl): UserRepository{
        return UserRepoImpl()
    }
}