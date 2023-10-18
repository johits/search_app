package com.torder.search_app.data.core.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "keep")
data class KeepEntity(
    @PrimaryKey(autoGenerate = true)
    val uid: Int = 0,
    val kind: String,
    @ColumnInfo(THUMBNAIL_URL)
    val thumbnailUrl: String,
    val datetime: String,
    @ColumnInfo(IS_HEART)
    val isHeart: Boolean
) {
    companion object {
        const val THUMBNAIL_URL = "thumbnail_url"
        const val IS_HEART = "is_heart"
    }
}
