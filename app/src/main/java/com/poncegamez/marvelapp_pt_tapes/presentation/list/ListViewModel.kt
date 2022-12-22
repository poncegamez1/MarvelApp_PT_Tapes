package com.poncegamez.marvelapp_pt_tapes.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poncegamez.marvelapp_pt_tapes.repository.ComicsRepository
import com.poncegamez.marvelapp_pt_tapes.model.Comic
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
class ListViewModel @Inject constructor(
    private val repository: ComicsRepository,
    private val coroutineContext: CoroutineContext = Dispatchers.IO
) : ViewModel() {

    private var comicsState: MutableLiveData<List<Comic>> = MutableLiveData<List<Comic>>()
    val onComicsState: LiveData<List<Comic>> get() = comicsState

    fun getComicsFromServer() {
        viewModelScope.launch(coroutineContext) {
            comicsState.postValue(repository.getComics())
        }
    }
}