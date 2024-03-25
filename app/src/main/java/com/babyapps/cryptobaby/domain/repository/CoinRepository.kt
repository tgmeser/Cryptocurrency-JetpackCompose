package com.babyapps.cryptobaby.domain.repository

import com.babyapps.cryptobaby.data.remote.dto.CoinDetailDto
import com.babyapps.cryptobaby.data.remote.dto.CoinDto

// Creating Repo as interface helps test cases a lot
interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailDto
}