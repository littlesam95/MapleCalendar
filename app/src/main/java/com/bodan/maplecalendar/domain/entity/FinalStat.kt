package com.bodan.maplecalendar.domain.entity

import androidx.annotation.Keep

@Keep
data class FinalStat(
    val statName: String,
    val statValue: String?
)