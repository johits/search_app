package com.torder.search_app.data.search.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.torder.search_app.data.core.room.entity.KeepEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface KeepDao {
    @Query("SELECT * FROM keep")
    fun getAll(): Flow<List<KeepEntity>>

    @Insert
    fun insertKeep(keep: KeepEntity)

    @Query("DELETE FROM keep WHERE thumbnail_url = :thumbnailUrl")
    fun deleteKeep(thumbnailUrl: String)
}