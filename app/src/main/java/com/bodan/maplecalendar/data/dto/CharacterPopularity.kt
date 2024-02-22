package com.bodan.maplecalendar.data.dto

import com.squareup.moshi.Json

data class CharacterPopularity(
    @Json(name = "popularity")
    val characterPopularity: Int = 0
)