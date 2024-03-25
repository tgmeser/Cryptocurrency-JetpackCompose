package com.babyapps.cryptobaby.presentation.coin_detail

import com.babyapps.cryptobaby.domain.model.Coin
import com.babyapps.cryptobaby.domain.model.CoinDetail
import com.babyapps.cryptobaby.util.Resource

data class CoinDetailState (
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)