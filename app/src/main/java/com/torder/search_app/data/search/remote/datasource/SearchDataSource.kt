package com.torder.search_app.data.search.remote.datasource

import com.torder.search_app.data.search.remote.model.ImageResponse
import com.torder.search_app.data.search.remote.model.VideoResponse

interface SearchDataSource {
    suspend fun getImage(query: String): List<ImageResponse>
    suspend fun getVideo(query: String): List<VideoResponse>
}