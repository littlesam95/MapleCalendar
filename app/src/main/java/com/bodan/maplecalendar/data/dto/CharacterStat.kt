package com.bodan.maplecalendar.data.dto

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class CharacterStat(
    @Json(name = "final_stat")
    val finalStats: List<FinalStat>
)
