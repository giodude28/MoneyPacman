package io.giodude.moneypacman.Network

import io.giodude.moneypacman.Model.AdDisModel
import io.giodude.moneypacman.Model.WayModel
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiService {


    private val Wayapi: MoneyApi
    private val Adapi: MoneyApi
    init {
        Wayapi = Retrofit.Builder()
            .baseUrl("http://45.66.164.9:7568/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(MoneyApi::class.java)

        Adapi = Retrofit.Builder()
            .baseUrl("http://45.66.164.9:7569/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(MoneyApi::class.java)
    }

    fun getWay(): Single<List<WayModel>>{
        return Wayapi.getWay()
    }

    fun getAD(): Single<List<AdDisModel>>{
        return Adapi.getAD()
    }
}