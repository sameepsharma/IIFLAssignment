package com.sameep.iiflassignment.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sameep.iiflassignment.rest.response.ResponseItem

@Dao
interface ArticlesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArticles(list: List<ResponseItem>)

    @Query("select * from articles_table")
    fun getSavedArticles(): List<ResponseItem>

}