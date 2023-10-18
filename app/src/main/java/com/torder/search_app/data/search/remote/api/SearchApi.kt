package com.torder.search_app.data.search.remote.api

import com.torder.search_app.data.core.retrofit.model.KakaoResponse
import com.torder.search_app.data.search.remote.model.ImageResponse
import com.torder.search_app.data.search.remote.model.VideoResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApi {
    @GET("v2/search/image")
    suspend fun getImage(
        @Query("query") query: String
    ): KakaoResponse<ImageResponse>

    @GET("v2/search/vclip")
    suspend fun getVideo(
        @Query("query") query: String
    ): KakaoResponse<VideoResponse>
}