package com.programmsoft.room.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation

@Entity
data class ContentDataWithCategories(
    @Embedded
    val category: ContentDataCategory,
    @Relation(
        parentColumn = "id",
        entityColumn = "categoryId"
    )
    val contents: List<ContentData>,
)