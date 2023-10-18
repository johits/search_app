package com.torder.search_app.data.search.local.mapper

import com.torder.search_app.data.core.room.entity.KeepEntity
import com.torder.search_app.domain.keep.model.KeepModel

fun KeepModel.toEntity(): KeepEntity {
    return KeepEntity(
        kind = kind,
        thumbnailUrl = thumbnailUrl,
        datetime = datetime,
        isHeart = isHeart
    )
}

fun KeepEntity.toModel(): KeepModel {
    return KeepModel(
        kind = kind,
        thumbnailUrl = thumbnailUrl,
        datetime = datetime,
        isHeart = isHeart
    )
}