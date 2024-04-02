package com.example.dorbbytask.repository

import com.example.dorbbytask.models.AuthorResultItem
import com.example.dorbbytask.network.ApiInterface
import com.example.dorbbytask.network.ResponseState

class MainRepository(private val apiInterface: ApiInterface) {


    suspend fun getPersonList(): ResponseState<ArrayList<AuthorResultItem>> {
        return try {
            val result = apiInterface.getPersonList()
            ResponseState.Success(result)
        } catch (e: Exception) {
            ResponseState.Error(e.message ?: "Unknown error")
        }
    }
}