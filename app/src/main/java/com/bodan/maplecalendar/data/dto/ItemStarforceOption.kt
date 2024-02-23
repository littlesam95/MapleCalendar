package com.bodan.maplecalendar.data.dto

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class ItemStarforceOption(
    @Json(name = "str")
    val itemStarforceStr: String = "",

    @Json(name = "dex")
    val itemStarforceDex: String = "",

    @Json(name = "int")
    val itemStarforceInt: String = "",

    @Json(name = "luk")
    val itemStarforceLuk: String = "",

    @Json(name = "max_hp")
    val itemStarforceMaxHp: String = "",

    @Json(name = "max_mp")
    val itemStarforceMaxMp: String = "",

    @Json(name = "attack_power")
    val itemStarforceAttackPower: String = "",

    @Json(name = "magic_power")
    val itemStarforceMagicPower: String = "",

    @Json(name = "armor")
    val itemStarforceArmor: String = "",

    @Json(name = "speed")
    val itemStarforceSpeed: String = "",

    @Json(name = "jump")
    val itemStarforceJump: String = ""
)
