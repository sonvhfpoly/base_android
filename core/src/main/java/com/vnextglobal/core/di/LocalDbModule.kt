package com.vnextglobal.core.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.vnextglobal.core.database.BaseDatabase
import com.vnextglobal.core.database.LocalDbConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object LocalDbModule {

    @Singleton
    @Provides
    fun provideLocalDb(@ApplicationContext context:Context):BaseDatabase{
        return Room.databaseBuilder(
            context,
            BaseDatabase::class.java, LocalDbConstants.dbName
        ).build()
    }
}