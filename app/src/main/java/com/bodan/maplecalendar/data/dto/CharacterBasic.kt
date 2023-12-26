package com.bodan.maplecalendar.data.dto

import com.squareup.moshi.Json

data class CharacterBasic(
    @Json(name = "character_name")
    val characterName: String,

    @Json(name = "world_name")
    val worldName: String,

    @Json(name = "character_class")
    val characterClass: String,

    @Json(name = "character_level")
    val characterLevel: Int,

    @Json(name = "character_guild_name")
    val characterGuildName: String,

    @Json(name = "character_image")
    val characterImage: String
)
