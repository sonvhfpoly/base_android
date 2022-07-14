package com.vnextglobal.core.di

import com.vnextglobal.core.network.NetworkConstants.BASE_URL
import com.vnextglobal.core.network.NetworkService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
 internal object NetworkModule {

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class LoggerInterceptor

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class LoggerOkHttp

    @LoggerInterceptor
    @Provides
    fun provideLoggerInterceptor(): Interceptor{
        return HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }
    }

    @LoggerOkHttp
    @Provides
    fun provideLoggerHttp(@LoggerInterceptor logger: Interceptor):OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()
    }

    @Singleton
    @Provides
    fun provideBasicNetworkService(@LoggerOkHttp httpClient: OkHttpClient): NetworkService{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NetworkService::class.java)
    }
}