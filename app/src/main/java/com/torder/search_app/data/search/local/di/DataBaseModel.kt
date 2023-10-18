package com.torder.search_app.data.search.local.di

import com.torder.search_app.data.search.local.KeepDatabase
import com.torder.search_app.data.search.local.dao.KeepDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModel {
    @Provides
    @Singleton
    fun provideKeepDao(
        db: KeepDatabase
    ): KeepDao = db.keepDao()
}