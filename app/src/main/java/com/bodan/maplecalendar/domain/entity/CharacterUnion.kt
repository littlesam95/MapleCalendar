package com.bodan.maplecalendar.domain.entity

import androidx.annotation.Keep

@Keep
data class CharacterUnion(
    val characterUnionLevel: Int = 0,
    val characterUnionGrade: String = "",
    val characterUnionArtifactLevel: Int? = null,
    val characterUnionArtifactExp: Int? = null,
    val characterUnionArtifactPoint: Int? = null,
)