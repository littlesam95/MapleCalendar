package com.bodan.maplecalendar.domain.entity

import androidx.annotation.Keep

@Keep
data class CharacterCashItemColoringPrism(
    val colorRange: String,
    val hue: String,
    val saturation: String,
    val value: String
)