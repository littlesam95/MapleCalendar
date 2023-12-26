package com.bodan.maplecalendar.data.dto

import com.squareup.moshi.Json

data class CharacterStat(
    @Json(name = "final_stat")
    val finalStats: List<FinalStat>
)
