package com.torder.search_app.domain.search.model

data class SearchResult(
    val kind: String,
    val thumbnailUrl: String,
    val datetime: String,
    val isHeart: Boolean = false
)