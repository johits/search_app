package com.torder.search_app.data.search.datasource

import com.torder.search_app.data.search.model.ImageResponse
import com.torder.search_app.data.search.model.VideoResponse

interface SearchDataSource {
    suspend fun getImage(query: String): List<ImageResponse>
    suspend fun getVideo(query: String): List<VideoResponse>
}