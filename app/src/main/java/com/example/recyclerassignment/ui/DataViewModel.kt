package com.androiddevs.newsapp.ui

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.ConnectivityManager.*
import android.net.NetworkCapabilities.*
import android.os.Build
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.recyclerassignment.models.Teacher
import com.example.recyclerassignment.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response
import java.io.IOException

class DataViewModel(app:Application, val repository: Repository): AndroidViewModel(app){
    val data: MutableLiveData<Teacher> = MutableLiveData()

    init {
        getDetails()
    }

    fun getDetails(){
        viewModelScope.launch {
            var res = repository.getDetails()
            data.value = res.body()
        }
    }
}