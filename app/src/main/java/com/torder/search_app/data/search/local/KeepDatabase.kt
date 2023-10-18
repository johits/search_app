package com.torder.search_app.data.search.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.torder.search_app.data.core.room.entity.KeepEntity
import com.torder.search_app.data.search.local.dao.KeepDao

@Database(
    version = 1,
    entities = [KeepEntity::class]
)
abstract class KeepDatabase : RoomDatabase() {
    abstract fun keepDao(): KeepDao
}