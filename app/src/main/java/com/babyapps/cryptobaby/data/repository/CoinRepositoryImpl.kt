package com.babyapps.cryptobaby.data.repository

import com.babyapps.cryptobaby.data.remote.CoinApi
import com.babyapps.cryptobaby.data.remote.dto.CoinDetailDto
import com.babyapps.cryptobaby.data.remote.dto.CoinDto
import com.babyapps.cryptobaby.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(private val coinApi: CoinApi): CoinRepository {
    override suspend fun getCoins(): List<CoinDto> = coinApi.getCoins()
    override suspend fun getCoinById(coinId: String): CoinDetailDto = coinApi.getCoinById(coinId)
}