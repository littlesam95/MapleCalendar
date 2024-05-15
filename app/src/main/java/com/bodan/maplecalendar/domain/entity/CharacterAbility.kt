package com.bodan.maplecalendar.domain.entity

import androidx.annotation.Keep

@Keep
data class CharacterAbility(
    val remainFame: String,
    val abilitys: List<CharacterAbilityPreset>
)
