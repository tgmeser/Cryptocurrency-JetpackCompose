package com.babyapps.cryptobaby.data.remote

import com.babyapps.cryptobaby.data.remote.dto.CoinDetailDto
import com.babyapps.cryptobaby.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinID}")
    suspend fun getCoinById(@Path("coinID") coinID: String): CoinDetailDto
}