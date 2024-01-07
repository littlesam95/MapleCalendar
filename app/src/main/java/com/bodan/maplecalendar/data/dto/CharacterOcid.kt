package com.bodan.maplecalendar.data.dto

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class CharacterOcid(
    @Json(name = "ocid")
    val ocid: String = ""
)
