package com.babyapps.cryptobaby.presentation.coin_list

import com.babyapps.cryptobaby.domain.model.Coin
import com.babyapps.cryptobaby.util.Resource

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)