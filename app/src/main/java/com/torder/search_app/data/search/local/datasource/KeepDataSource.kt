package com.torder.search_app.data.search.local.datasource

import com.torder.search_app.data.core.room.entity.KeepEntity
import kotlinx.coroutines.flow.Flow

interface KeepDataSource {
    fun insertHeart(keepEntity: KeepEntity)
    fun deleteHeart(thumbnailUrl: String)
    fun getAllHeart(): Flow<List<KeepEntity>>
}