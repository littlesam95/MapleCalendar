package com.bodan.maplecalendar.data.dto

import com.squareup.moshi.Json

data class CharacterOcid(
    @Json(name = "ocid")
    val ocid: String
)
