package com.torder.search_app.data.search.remote.di

import com.torder.search_app.data.search.remote.datasource.SearchDataSource
import com.torder.search_app.data.search.remote.datasource.SearchDataSourceImpl
import com.torder.search_app.data.search.remote.repository.SearchRepositoryImpl
import com.torder.search_app.domain.search.repository.SearchRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class SearchModule {

    @Binds
    abstract fun bindImageDataSource(
        impl: SearchDataSourceImpl
    ): SearchDataSource

    @Binds
    abstract fun bindImageRepository(
        impl: SearchRepositoryImpl
    ): SearchRepository
}