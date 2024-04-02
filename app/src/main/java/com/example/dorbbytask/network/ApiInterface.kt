package com.example.dorbbytask.network
import com.example.dorbbytask.models.AuthorResultItem
import retrofit2.http.GET

interface ApiInterface {
    @GET(ApiUtils.PERSON_LIST)
    suspend fun getPersonList(): ArrayList<AuthorResultItem>
}


