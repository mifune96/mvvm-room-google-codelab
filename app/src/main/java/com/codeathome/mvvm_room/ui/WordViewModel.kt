package com.codeathome.mvvm_room.ui

import androidx.lifecycle.*
import com.codeathome.mvvm_room.Repository.WordRepository
import com.codeathome.mvvm_room.Repository.local.Word
import kotlinx.coroutines.launch

class WordViewModel(private val repository: WordRepository): ViewModel() {
    val allWords: LiveData<List<Word>> = repository.allWords.asLiveData()

    fun insert(word: Word) = viewModelScope.launch {
        repository.insert(word)
    }
}

class WordViewModelFactory(private val repository: WordRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WordViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return WordViewModel(repository) as T
        }
        throw IllegalAccessException("Unknown ViewModel class")
    }
}