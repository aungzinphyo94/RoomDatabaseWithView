package com.azp.roomwithview.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.azp.roomwithview.entity.Word

@Dao
interface WordDao{

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    @Query("Select * From word_table ORDER BY word ASC")
    fun getAlphabetizedWords(): LiveData<List<Word>>

    @Query("Delete From word_table Where word= :word")
    suspend fun deleteAll(word: String)

}