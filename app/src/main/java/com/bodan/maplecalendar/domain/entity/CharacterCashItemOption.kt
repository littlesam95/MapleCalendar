package com.bodan.maplecalendar.domain.entity

import androidx.annotation.Keep

@Keep
data class CharacterCashItemOption(
    val optionType: String,
    val optionValue: String
)