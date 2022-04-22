package com.example.recyclerassignment.api

import com.example.recyclerassignment.models.Teacher
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface API {

    @GET("easygautam/data/users")
    suspend fun getDetails(
    ): Response<Teacher>
}