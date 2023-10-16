package com.torder.search_app.data.search.mapper

import com.torder.search_app.data.search.model.ImageResponse
import com.torder.search_app.data.search.model.VideoResponse
import com.torder.search_app.domain.search.model.SearchResult


fun ImageResponse.toModel(): SearchResult =
    SearchResult(
        kind = "image",
        thumbnailUrl = thumbnailUrl,
        datetime = datetime
    )

fun VideoResponse.toModel(): SearchResult =
    SearchResult(
        kind = "video",
        thumbnailUrl = thumbnail,
        datetime = datetime
    )