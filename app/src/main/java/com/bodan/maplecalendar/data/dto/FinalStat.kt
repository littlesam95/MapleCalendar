package com.bodan.maplecalendar.data.dto

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class FinalStat(
    @Json(name = "stat_name")
    val statName: String,

    @Json(name = "stat_value")
    val statValue: String
)
