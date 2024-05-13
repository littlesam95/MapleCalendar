package com.bodan.maplecalendar.domain.entity

import androidx.annotation.Keep

@Keep
data class CharacterAbilityInfo(
    val abilityNo: String,
    val abilityGrade: String,
    val abilityValue: String
)
