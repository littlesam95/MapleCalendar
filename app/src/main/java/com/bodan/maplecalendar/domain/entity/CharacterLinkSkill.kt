package com.bodan.maplecalendar.domain.entity

import androidx.annotation.Keep

@Keep
data class CharacterLinkSkill(
    val characterLinkSkills: List<List<CharacterSkillInfo>>,
    val characterOwnedLinkSkill: CharacterSkillInfo
)