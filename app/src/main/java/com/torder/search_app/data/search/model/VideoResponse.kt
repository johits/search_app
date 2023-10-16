package com.torder.search_app.data.search.model

import com.google.gson.annotations.SerializedName

data class VideoResponse(
    @SerializedName("thumbnail")
    val thumbnail: String,
    @SerializedName("datetime")
    val datetime: String
)
