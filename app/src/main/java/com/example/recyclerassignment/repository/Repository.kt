package com.example.recyclerassignment.repository

import com.example.recyclerassignment.api.RetrofitInstance

class Repository {
    suspend fun getDetails()=
        RetrofitInstance.api.getDetails()
}