package com.bodan.maplecalendar.domain.entity

import androidx.annotation.Keep

@Keep
data class CharacterSkill(
    val characterClass: String,
    val characterSkillGrade: String,
    val characterSkills: List<CharacterSkillInfo>
)