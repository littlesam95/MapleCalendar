package com.bodan.maplecalendar.domain.entity

import androidx.annotation.Keep

@Keep
data class CharacterHyperStatInfo(
    val statType: String,
    val statPoint: Int,
    val statLevel: Int,
    val statIncrease: String
)
