package com.bodan.maplecalendar.data.dto

import com.squareup.moshi.Json

data class CharacterUnion(
    @Json(name = "union_level")
    val characterUnionLevel: Int = 0,

    @Json(name = "union_grade")
    val characterUnionGrade: String = "",

    @Json(name = "union_artifact_level")
    val characterUnionArtifactLevel: Int = 0,

    @Json(name = "union_artifact_exp")
    val characterUnionArtifactExp: Int = 0,

    @Json(name = "union_artifact_point")
    val characterUnionArtifactPoint: Int = 0,
)