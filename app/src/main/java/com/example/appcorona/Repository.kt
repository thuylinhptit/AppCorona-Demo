package com.example.appcorona

import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import java.lang.Exception

interface  Repository{
    fun getCoronaInfo(): Flowable<List<CoronaCountry>>
}

class  RepositoryImpl( val coronaServices: CoronaServices): Repository{
    override fun getCoronaInfo(): Flowable<List<CoronaCountry>> {
        return  Flowable.create<List<CoronaCountry>>({ emitter ->
            try {
                val list = coronaServices.getAllCountryInfos().execute().body()
                emitter.onNext(list)
                emitter.onComplete()
            }catch ( ex: Exception ){
                emitter.onError(ex)
            }
        }, BackpressureStrategy.BUFFER).subscribeOn(Schedulers.io())
    }

}