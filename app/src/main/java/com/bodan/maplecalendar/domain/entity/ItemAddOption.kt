package com.bodan.maplecalendar.domain.entity

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class ItemAddOption(
    @Json(name = "str")
    val itemAddStr: String = "",

    @Json(name = "dex")
    val itemAddDex: String = "",

    @Json(name = "int")
    val itemAddInt: String = "",

    @Json(name = "luk")
    val itemAddLuk: String = "",

    @Json(name = "max_hp")
    val itemAddMaxHp: String = "",

    @Json(name = "max_mp")
    val itemAddMaxMp: String = "",

    @Json(name = "attack_power")
    val itemAddAttackPower: String = "",

    @Json(name = "magic_power")
    val itemAddMagicPower: String = "",

    @Json(name = "armor")
    val itemAddArmor: String = "",

    @Json(name = "speed")
    val itemAddSpeed: String = "",

    @Json(name = "jump")
    val itemAddJump: String = "",

    @Json(name = "boss_damage")
    val itemAddBossDamage: String = "",

    @Json(name = "damage")
    val itemAddDamage: String = "",

    @Json(name = "all_stat")
    val itemAddAllStat: String = "",

    @Json(name = "equipment_level_decrease")
    val itemAddEquipmentLevelDecrease: String = "",
)
