package com.bodan.maplecalendar.domain.entity

import androidx.annotation.Keep

@Keep
data class CharacterSkillInfo(
    val skillName: String,
    val skillDescription: String,
    val skillLevel: String,
    val skillEffect: String,
    val skillIcon: String
)
