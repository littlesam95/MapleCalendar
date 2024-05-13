package com.bodan.maplecalendar.domain.entity

import androidx.annotation.Keep

@Keep
data class CharacterAbility(
    val remainFame: Int,
    val abilityFirstPreset: CharacterAbilityPreset,
    val abilitySecondPreset: CharacterAbilityPreset,
    val abilityThirdPreset: CharacterAbilityPreset
)
