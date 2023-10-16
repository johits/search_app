package com.torder.search_app.data.search.datasource

import com.torder.search_app.data.core.retrofit.di.IODispatcher
import com.torder.search_app.data.search.api.SearchApi
import com.torder.search_app.data.search.model.ImageResponse
import com.torder.search_app.data.search.model.VideoResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SearchDataSourceImpl @Inject constructor(
    private val api: SearchApi,
    @IODispatcher private val dispatcher: CoroutineDispatcher
) : SearchDataSource {
    override suspend fun getImage(query: String): List<ImageResponse> {
        return withContext(dispatcher) {
            val response = api.getImage(query = query)
            response.documents
        }
    }

    override suspend fun getVideo(query: String): List<VideoResponse> {
        return withContext(dispatcher) {
            val response = api.getVideo(query = query)
            response.documents
        }
    }
}