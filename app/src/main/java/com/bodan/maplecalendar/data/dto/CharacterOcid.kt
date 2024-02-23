package com.bodan.maplecalendar.data.dto

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class CharacterOcid(
    @Json(name = "ocid")
    val ocid: String = ""
)
