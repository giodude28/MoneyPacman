package io.giodude.moneypacman.Network

import io.giodude.moneypacman.Model.AdDisModel
import io.giodude.moneypacman.Model.WayModel
import io.reactivex.Single
import retrofit2.http.GET

interface MoneyApi {

    @GET("monkeymaking")
    fun getWay(): Single<List<WayModel>>

    @GET("monkeymakingadvantageandisadvantages")
    fun getAD(): Single<List<AdDisModel>>
}