package com.azp.roomwithview.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.azp.roomwithview.database.WordDatabase
import com.azp.roomwithview.entity.Word
import com.azp.roomwithview.repository.WordRepository
import kotlinx.coroutines.launch

class WordViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: WordRepository

    val allWords: LiveData<List<Word>>

    init {
        val wordDao = WordDatabase.getDatabase(application)
            .wordDao()
        repository = WordRepository(wordDao)
        allWords = repository.allWords
    }

    fun insert(word: Word) = viewModelScope.launch {
        repository.insert(word)
    }

    fun deletes() = viewModelScope.launch {
        repository.deleteAll()
    }

}