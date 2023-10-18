package com.torder.search_app.data.search.local.repository

import com.torder.search_app.data.search.local.datasource.KeepDataSource
import com.torder.search_app.data.search.local.mapper.toEntity
import com.torder.search_app.data.search.local.mapper.toModel
import com.torder.search_app.domain.keep.model.KeepModel
import com.torder.search_app.domain.keep.repository.KeepRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class KeepRepositoryImpl @Inject constructor(
    private val dataSource: KeepDataSource
) : KeepRepository {
    override fun insertHeart(keepModel: KeepModel) {
        dataSource.insertHeart(keepModel.toEntity())
    }

    override fun deleteHeart(thumbnailUrl: String) {
        dataSource.deleteHeart(thumbnailUrl)
    }

    override fun getAllHeart(): Flow<List<KeepModel>> {
        return dataSource.getAllHeart().map {
            it.map { entity -> entity.toModel() }
        }
    }
}