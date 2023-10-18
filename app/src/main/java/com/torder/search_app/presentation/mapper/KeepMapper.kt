package com.torder.search_app.presentation.mapper

import com.torder.search_app.domain.keep.model.KeepModel
import com.torder.search_app.domain.search.model.SearchResult

fun SearchResult.toKeepModel(): KeepModel {
    return KeepModel(
        kind = kind,
        thumbnailUrl = thumbnailUrl,
        datetime = datetime,
        isHeart = isHeart
    )
}
