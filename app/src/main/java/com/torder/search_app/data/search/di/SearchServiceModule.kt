package com.torder.search_app.data.search.di

import com.torder.search_app.data.core.retrofit.interceptor.HeaderInterceptor
import com.torder.search_app.data.search.api.SearchApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SearchServiceModule {
    @Provides
    fun provideHeaderInterceptor(): HeaderInterceptor = HeaderInterceptor()

    @Provides
    @Singleton
    fun provideSearchService(
        retrofit: Retrofit
    ): SearchApi = retrofit.create(SearchApi::class.java)
}