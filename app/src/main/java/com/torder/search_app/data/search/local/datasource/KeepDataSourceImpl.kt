package com.torder.search_app.data.search.local.datasource

import com.torder.search_app.data.core.room.entity.KeepEntity
import com.torder.search_app.data.search.local.dao.KeepDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class KeepDataSourceImpl @Inject constructor(
    private val keepDao: KeepDao
) : KeepDataSource {
    override fun insertHeart(keep: KeepEntity) {
        return keepDao.insertKeep(keep)
    }

    override fun deleteHeart(kthumbnailUrl: String) {
        return keepDao.deleteKeep(kthumbnailUrl)
    }

    override fun getAllHeart(): Flow<List<KeepEntity>> {
        return keepDao.getAll()
    }
}