package com.babyapps.cryptobaby.domain.model

import com.babyapps.cryptobaby.data.remote.dto.TeamMember

data class CoinDetail(
    val description: String,
    val coinId: String,
    val name: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamMember>,
)