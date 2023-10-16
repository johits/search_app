package com.torder.search_app.data.core.retrofit.model

import com.google.gson.annotations.SerializedName

data class KakaoResponse<T>(
    @SerializedName("documents")
    val documents: List<T>
)
