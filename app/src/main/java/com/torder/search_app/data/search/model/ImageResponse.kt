package com.torder.search_app.data.search.model

import com.google.gson.annotations.SerializedName


data class ImageResponse(
    @SerializedName("thumbnail_url")
    val thumbnailUrl: String,
    @SerializedName("datetime")
    val datetime: String
)
