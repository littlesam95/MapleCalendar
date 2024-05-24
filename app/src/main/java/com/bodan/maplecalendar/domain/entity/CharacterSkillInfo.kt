package com.bodan.maplecalendar.domain.entity

import androidx.annotation.Keep

@Keep
data class CharacterSkillInfo(
    val skillName: String,
    val skillDescription: String,
    val skillLevel: String,
    val skillLevelNext: String,
    val skillEffect: String?,
    val skillEffectNext: String?,
    val skillIcon: String
)
