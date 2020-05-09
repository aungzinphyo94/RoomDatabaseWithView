package com.azp.roomwithview.repository

import androidx.lifecycle.LiveData
import com.azp.roomwithview.dao.WordDao
import com.azp.roomwithview.entity.Word

class WordRepository (private val wordDao: WordDao){

    val allWords: LiveData<List<Word>> = wordDao.getAlphabetizedWords()

    suspend fun insert(word: Word){
        wordDao.insert(word)
    }

    suspend fun deleteAll(){
//        wordDao.deleteAll()
    }
}