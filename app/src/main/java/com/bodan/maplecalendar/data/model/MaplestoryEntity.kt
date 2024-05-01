package com.bodan.maplecalendar.data.model

import androidx.annotation.Keep
import com.bodan.maplecalendar.domain.entity.FinalStat
import com.bodan.maplecalendar.domain.entity.ItemEquipment
import com.bodan.maplecalendar.domain.entity.ItemTitle
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class OcidEntity(
    @Json(name = "ocid")
    val ocid: String = ""
)

@Keep
@JsonClass(generateAdapter = true)
data class BasicEntity(
    @Json(name = "character_name")
    val characterName: String = "",

    @Json(name = "world_name")
    val worldName: String = "",

    @Json(name = "character_gender")
    val characterGender: String = "",

    @Json(name = "character_class")
    val characterClass: String = "",

    @Json(name = "character_level")
    val characterLevel: Int = 0,

    @Json(name = "character_guild_name")
    val characterGuildName: String? = null,

    @Json(name = "character_image")
    val characterImage: String = ""
)

@Keep
@JsonClass(generateAdapter = true)
data class StatEntity(
    @Json(name = "final_stat")
    val finalStats: List<FinalStat>
)

@Keep
@JsonClass(generateAdapter = true)
data class ItemEquipmentEntity(
    @Json(name = "item_equipment")
    val itemEquipments: List<ItemEquipment>,

    @Json(name = "title")
    val itemTitle: ItemTitle?
)

@Keep
@JsonClass(generateAdapter = true)
data class UnionEntity(
    @Json(name = "union_level")
    val characterUnionLevel: Int = 0,

    @Json(name = "union_grade")
    val characterUnionGrade: String = "",

    @Json(name = "union_artifact_level")
    val characterUnionArtifactLevel: Int? = null,

    @Json(name = "union_artifact_exp")
    val characterUnionArtifactExp: Int? = null,

    @Json(name = "union_artifact_point")
    val characterUnionArtifactPoint: Int? = null,
)

@Keep
@JsonClass(generateAdapter = true)
data class PopularityEntity(
    @Json(name = "popularity")
    val characterPopularity: Int = 0
)

@Keep
@JsonClass(generateAdapter = true)
data class DojangEntity(
    @Json(name = "dojang_best_floor")
    val characterDojangBestFloor: Int = 0
)