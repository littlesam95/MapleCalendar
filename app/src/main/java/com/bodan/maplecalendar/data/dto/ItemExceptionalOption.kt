package com.bodan.maplecalendar.data.dto

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class ItemExceptionalOption(
    @Json(name = "str")
    val itemExceptionalStr: String,

    @Json(name = "dex")
    val itemExceptionalDex: String,

    @Json(name = "int")
    val itemExceptionalInt: String,

    @Json(name = "luk")
    val itemExceptionalLuk: String,

    @Json(name = "max_hp")
    val itemExceptionalMaxHp: String,

    @Json(name = "max_mp")
    val itemExceptionalMaxMp: String,

    @Json(name = "attack_power")
    val itemExceptionalAttackPower: String,

    @Json(name = "magic_power")
    val itemExceptionalMagicPower: String,
)
