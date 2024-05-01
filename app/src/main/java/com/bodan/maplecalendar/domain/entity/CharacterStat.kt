package com.bodan.maplecalendar.domain.entity

import androidx.annotation.Keep

@Keep
data class CharacterStat(
    val finalStats: List<FinalStat>
)