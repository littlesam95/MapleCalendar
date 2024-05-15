package com.bodan.maplecalendar.domain.entity

import androidx.annotation.Keep

@Keep
data class CharacterAbilityPreset(
    val abilityPresetGrade: String,
    val abilityInfo: List<CharacterAbilityInfo>
)
