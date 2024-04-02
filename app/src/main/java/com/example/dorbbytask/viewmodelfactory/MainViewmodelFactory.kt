package com.example.dorbbytask.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dorbbytask.repository.MainRepository
import com.example.dorbbytask.viewmodel.MainViewmodel

class MainViewmodelFactory(private val repository: MainRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(MainViewmodel::class.java)) {
            return MainViewmodel(repository) as T
        }
        throw IllegalArgumentException("Unknown Exception from Viewmodel")

    }
}