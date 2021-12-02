package com.codeathome.mvvm_room.Repository

import androidx.annotation.WorkerThread
import com.codeathome.mvvm_room.Repository.local.Word
import com.codeathome.mvvm_room.Repository.local.WordDao
import kotlinx.coroutines.flow.Flow

class WordRepository (private val wordDao: WordDao){

    val allWords: Flow<List<Word>> = wordDao.getAlphabetizedWords()

    @Suppress("RedudantSuspendModifier")
    @WorkerThread
    suspend fun insert(word: Word){
        wordDao.insert(word)
    }
}