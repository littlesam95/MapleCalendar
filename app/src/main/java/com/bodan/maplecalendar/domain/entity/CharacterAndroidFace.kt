package com.bodan.maplecalendar.domain.entity

import androidx.annotation.Keep

@Keep
data class CharacterAndroidFace(
    val faceName: String?,
    val baseColor: String?,
    val mixColor: String?,
    val mixRate: String
)