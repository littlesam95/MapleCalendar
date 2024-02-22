package com.bodan.maplecalendar.data.dto

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class ItemBaseOption(
    @Json(name = "str")
    val itemBaseStr: String = "",

    @Json(name = "dex")
    val itemBaseDex: String = "",

    @Json(name = "int")
    val itemBaseInt: String = "",

    @Json(name = "luk")
    val itemBaseLuk: String = "",

    @Json(name = "max_hp")
    val itemBaseMaxHp: String = "",

    @Json(name = "max_mp")
    val itemBaseMaxMp: String = "",

    @Json(name = "attack_power")
    val itemBaseAttackPower: String = "",

    @Json(name = "magic_power")
    val itemBaseMagicPower: String = "",

    @Json(name = "armor")
    val itemBaseArmor: String = "",

    @Json(name = "speed")
    val itemBaseSpeed: String = "",

    @Json(name = "jump")
    val itemBaseJump: String = "",

    @Json(name = "boss_damage")
    val itemBaseBossDamage: String = "",

    @Json(name = "ignore_monster_armor")
    val itemBaseIgnoreMonsterArmor: String = "",

    @Json(name = "all_stat")
    val itemBaseAllStat: String = "",

    @Json(name = "max_hp_rate")
    val itemBaseMaxHpRate: String = "",

    @Json(name = "max_mp_rate")
    val itemBaseMaxMpRate: String = "",

    @Json(name = "base_equipment_level")
    val itemBaseBaseEquipmentLevel: String = "",
)
