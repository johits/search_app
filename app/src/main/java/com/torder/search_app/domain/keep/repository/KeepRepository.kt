package com.torder.search_app.domain.keep.repository

import com.torder.search_app.domain.keep.model.KeepModel
import kotlinx.coroutines.flow.Flow

interface KeepRepository {
    fun insertHeart(keepModel: KeepModel)
    fun deleteHeart(thumbnailUrl: String)
    fun getAllHeart(): Flow<List<KeepModel>>
}