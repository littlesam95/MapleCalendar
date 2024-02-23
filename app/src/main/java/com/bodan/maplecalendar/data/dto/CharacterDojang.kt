package com.bodan.maplecalendar.data.dto

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class CharacterDojang(
    @Json(name = "dojang_best_floor")
    val characterDojangBestFloor: Int = 0
)
