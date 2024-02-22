package com.bodan.maplecalendar.data.dto

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class ItemTotalOption(
    @Json(name = "str")
    val itemTotalStr: String = "",

    @Json(name = "dex")
    val itemTotalDex: String = "",

    @Json(name = "int")
    val itemTotalInt: String = "",

    @Json(name = "luk")
    val itemTotalLuk: String = "",

    @Json(name = "max_hp")
    val itemTotalMaxHp: String = "",

    @Json(name = "max_mp")
    val itemTotalMaxMp: String = "",

    @Json(name = "attack_power")
    val itemTotalAttackPower: String = "",

    @Json(name = "magic_power")
    val itemTotalMagicPower: String = "",

    @Json(name = "armor")
    val itemTotalArmor: String = "",

    @Json(name = "speed")
    val itemTotalSpeed: String = "",

    @Json(name = "jump")
    val itemTotalJump: String = "",

    @Json(name = "boss_damage")
    val itemTotalBossDamage: String = "",

    @Json(name = "ignore_monster_armor")
    val itemTotalIgnoreMonsterArmor: String = "",

    @Json(name = "all_stat")
    val itemTotalAllStat: String = "",

    @Json(name = "damage")
    val itemTotalDamage: String = "",

    @Json(name = "equipment_level_decrease")
    val itemTotalEquipmentLevelDecrease: String = "",

    @Json(name = "max_hp_rate")
    val itemTotalMaxHpRate: String = "",

    @Json(name = "max_mp_rate")
    val itemTotalMaxMpRate: String = ""
)
