package com.bodan.maplecalendar.domain.entity

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class FinalStat(
    @Json(name = "stat_name")
    val statName: String,

    @Json(name = "stat_value")
    val statValue: String?
)
