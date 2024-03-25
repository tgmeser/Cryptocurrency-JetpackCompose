package com.babyapps.cryptobaby.data.remote.dto

import com.babyapps.cryptobaby.domain.model.Coin
import com.google.gson.annotations.SerializedName

// DTO represents the data model what comes from API
data class CoinDto(
    val id: String,
    @SerializedName("is_active")
    val is_active: Boolean,
    @SerializedName("is_new")
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

fun CoinDto.mapToCoin(): Coin = Coin(id, is_active, name, rank, symbol)