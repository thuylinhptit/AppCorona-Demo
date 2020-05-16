package com.example.appcorona

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory() : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val coronaServices = CoronaRetrofit.getCoronaService()
        val repository = RepositoryImpl(coronaServices)
        return MainViewModel(repository) as T
    }

}