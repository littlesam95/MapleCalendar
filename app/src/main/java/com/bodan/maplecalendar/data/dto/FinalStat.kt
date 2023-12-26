package com.bodan.maplecalendar.data.dto

import com.squareup.moshi.Json

data class FinalStat(
    @Json(name = "stat_name")
    val statName: String,

    @Json(name = "stat_value")
    val statValue: String
)
