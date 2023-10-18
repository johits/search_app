package com.torder.search_app.data.search.local.di

import com.torder.search_app.data.search.local.datasource.KeepDataSource
import com.torder.search_app.data.search.local.datasource.KeepDataSourceImpl
import com.torder.search_app.data.search.local.repository.KeepRepositoryImpl
import com.torder.search_app.domain.keep.repository.KeepRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class KeepModule {
    @Binds
    abstract fun bindKeepDataSource(
        impl: KeepDataSourceImpl
    ): KeepDataSource

    @Binds
    abstract fun bindKeepRepository(
        impl: KeepRepositoryImpl
    ): KeepRepository
}