package com.example.appcorona

import android.provider.ContactsContract
import android.util.EventLog
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers

class MainViewModel ( val repository: Repository ): ViewModel(){

    val listCorona = MutableLiveData<List<UiModel>>()
    val isLoading = MutableLiveData<Boolean>().apply {
        value = false
    }

    val isError = MutableLiveData<Event<Boolean>>().apply {
        value = Event(false)
    }
    init {

        isLoading.value = true
        repository.getCoronaInfo()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                listCorona.value = it.map {
                    UiModel(
                        thumbnailUrl = it.contryInfo.flag,
                        name = it.country,
                        cases = it.cases.toLong(),
                        deaths = it.deaths.toLong(),
                        recoveries = it.recovered.toLong(),
                        onClick = {}
                    )
                }
            },{
                Log.d("AppLog", it.message)
                isLoading.value = false
                isError.value = Event(true)
            },{
                isLoading.value = false
            })
    }
}