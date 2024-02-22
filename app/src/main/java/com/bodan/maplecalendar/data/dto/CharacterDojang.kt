package com.bodan.maplecalendar.data.dto

import com.squareup.moshi.Json

data class CharacterDojang(
    @Json(name = "dojang_best_floor")
    val characterDojangBestFloor: Int = 0
)
