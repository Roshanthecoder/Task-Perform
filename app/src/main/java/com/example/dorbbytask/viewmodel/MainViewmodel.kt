package com.example.dorbbytask.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dorbbytask.models.AuthorResultItem
import com.example.dorbbytask.network.ResponseState
import com.example.dorbbytask.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewmodel(private val mainRepository: MainRepository) : ViewModel() {


    private var _authorList = MutableLiveData<ResponseState<ArrayList<AuthorResultItem>>>()

    val authorList: LiveData<ResponseState<ArrayList<AuthorResultItem>>>
        get() = _authorList

    fun getPersonList() {
        _authorList.value = ResponseState.Loading
        viewModelScope.launch(Dispatchers.IO) {
            val result = mainRepository.getPersonList()
            _authorList.postValue(result)
        }
    }
}