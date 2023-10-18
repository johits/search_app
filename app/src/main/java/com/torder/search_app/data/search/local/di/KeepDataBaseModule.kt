package com.torder.search_app.data.search.local.di

import android.content.Context
import androidx.room.Room
import com.torder.search_app.data.search.local.KeepDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object KeepDataBaseModule {

    @Provides
    @Singleton
    fun provideRoomDataBase(@ApplicationContext applicationContext: Context): KeepDatabase {
        return Room.databaseBuilder(applicationContext, KeepDatabase::class.java, "database")
            .allowMainThreadQueries()
            .build()
    }
}
