package com.babyapps.cryptobaby.domain.model

import com.google.gson.annotations.SerializedName

// That data model represents the data which is showed in UI
data class Coin(
    val id: String,
    val is_active: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
)
