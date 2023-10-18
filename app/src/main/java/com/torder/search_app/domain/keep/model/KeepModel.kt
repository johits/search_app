package com.torder.search_app.domain.keep.model

data class KeepModel(
    val kind: String,
    val thumbnailUrl: String,
    val datetime: String,
    val isHeart: Boolean = false
)
