package com.bodan.maplecalendar.domain.entity

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class ItemEtcOption(
    @Json(name = "str")
    val itemEtcStr: String = "",

    @Json(name = "dex")
    val itemEtcDex: String = "",

    @Json(name = "int")
    val itemEtcInt: String = "",

    @Json(name = "luk")
    val itemEtcLuk: String = "",

    @Json(name = "max_hp")
    val itemEtcMaxHp: String = "",

    @Json(name = "max_mp")
    val itemEtcMaxMp: String = "",

    @Json(name = "attack_power")
    val itemEtcAttackPower: String = "",

    @Json(name = "magic_power")
    val itemEtcMagicPower: String = "",

    @Json(name = "armor")
    val itemEtcArmor: String = "",

    @Json(name = "speed")
    val itemEtcSpeed: String = "",

    @Json(name = "jump")
    val itemEtcJump: String = ""
)
