package com.programmsoft.room.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.programmsoft.room.entity.ContentDataWithCategories

@Dao
interface ContentDataWithCategoriesDao {
    @Transaction
    @Query("SELECT *FROM ContentDataCategory where id = :id")
    fun getContentDataByCategory(id: Int): ContentDataWithCategories
}