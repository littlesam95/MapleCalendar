package com.bodan.maplecalendar.domain.entity

import androidx.annotation.Keep

@Keep
data class CharacterBasic(
    val characterName: String = "",
    val worldName: String = "",
    val characterGender: String = "",
    val characterClass: String = "",
    val characterLevel: Int = 0,
    val characterGuildName: String? = null,
    val characterImage: String = ""
)
